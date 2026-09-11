package com.ruml.ecommerce.core.b2b.factory.request;

import java.math.BigDecimal;
import java.time.Instant;

public record NegotiateQuoteRequest(
    String quoteId,
    BigDecimal customPrice,
    int minOrderQuantity,
    Instant expirationDate
) {}
