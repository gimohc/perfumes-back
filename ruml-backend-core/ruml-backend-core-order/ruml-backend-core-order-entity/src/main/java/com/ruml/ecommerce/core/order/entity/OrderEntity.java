package com.ruml.ecommerce.core.order.entity;

import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.order.identity.OrderId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "orders")
public class OrderEntity implements Entity<OrderId> {
    
    @EmbeddedId
    private OrderId id;

    protected OrderEntity() {
        // JPA requires default constructor
    }

    public OrderEntity(OrderId id) {
        this.id = id;
    }

    @Override
    public OrderId getId() {
        return id;
    }
}
