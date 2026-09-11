package com.ruml.ecommerce.core.b2b.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public record QuoteItem(
    String perfumeName,
    int requestedQuantity
) {
    public QuoteItem {
        if (requestedQuantity <= 0) {
            throw new IllegalArgumentException("Quantity must be strictly positive");
        }
    }
}
