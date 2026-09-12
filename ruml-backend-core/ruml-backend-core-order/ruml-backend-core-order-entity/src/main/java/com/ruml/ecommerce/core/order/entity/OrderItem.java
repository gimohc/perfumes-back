package com.ruml.ecommerce.core.order.entity;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class OrderItem {

    private String perfumeId;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    protected OrderItem() {
        // JPA requires default constructor
    }

    public OrderItem(String perfumeId, int quantity, BigDecimal unitPrice) {
        this.perfumeId = perfumeId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public String getPerfumeId() {
        return perfumeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
