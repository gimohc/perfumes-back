package com.ruml.ecommerce.core.inventory.entity;

import com.ruml.ecommerce.core.shared.exception.DomainException;

public record StockQuantity(int amount) {
    public StockQuantity {
        if (amount < 0) {
            throw new DomainException("INVALID_STOCK", "Stock quantity cannot be negative");
        }
    }
}
