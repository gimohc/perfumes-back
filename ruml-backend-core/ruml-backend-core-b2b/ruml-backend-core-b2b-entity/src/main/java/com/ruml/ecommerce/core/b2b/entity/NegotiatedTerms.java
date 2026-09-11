package com.ruml.ecommerce.core.b2b.entity;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;
import java.time.Instant;

@Embeddable
public record NegotiatedTerms(
    BigDecimal customPrice,
    int minOrderQuantity,
    Instant expirationDate
) {}
