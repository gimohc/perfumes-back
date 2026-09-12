package com.ruml.ecommerce.core.order.entity;

import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.order.identity.OrderId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

@jakarta.persistence.Entity
@Table(name = "orders")
public class OrderEntity implements Entity<OrderId> {
    
    @EmbeddedId
    private OrderId id;

    @Column(nullable = false)
    private String customerId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderItem> items = new ArrayList<>();

    @Column(nullable = false)
    private BigDecimal subtotal;

    @Column(nullable = false)
    private BigDecimal tax;

    @Column(nullable = false)
    private BigDecimal total;

    protected OrderEntity() {
        // JPA requires default constructor
    }

    public OrderEntity(OrderId id, String customerId, List<OrderItem> items, BigDecimal taxRate) {
        this.id = id;
        this.customerId = customerId;
        this.status = OrderStatus.PENDING;
        this.items = items;
        this.subtotal = items.stream()
                .map(OrderItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        this.tax = this.subtotal.multiply(taxRate);
        this.total = this.subtotal.add(this.tax);
    }

    @Override
    public OrderId getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void authorizePayment() {
        if (this.status != OrderStatus.PENDING) {
            throw new IllegalStateException("Order must be PENDING to authorize payment");
        }
        this.status = OrderStatus.PAYMENT_AUTHORIZED;
    }

    public void confirm() {
        if (this.status != OrderStatus.PAYMENT_AUTHORIZED) {
            throw new IllegalStateException("Order must be PAYMENT_AUTHORIZED to confirm");
        }
        this.status = OrderStatus.CONFIRMED;
    }
}
