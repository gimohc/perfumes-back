package com.ruml.ecommerce.core.perfume.entity.value;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public record BottleVolume(
    int milliliters
) {
    public BottleVolume {
        if (milliliters <= 0) {
            throw new IllegalArgumentException("Bottle volume must be strictly positive");
        }
    }
}
