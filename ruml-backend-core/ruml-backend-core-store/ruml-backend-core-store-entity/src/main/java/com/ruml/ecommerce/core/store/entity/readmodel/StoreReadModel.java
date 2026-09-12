package com.ruml.ecommerce.core.store.entity.readmodel;

import java.math.BigDecimal;

public record StoreReadModel(
        String storeId,
        String currency,
        int minimumOrderQuantity,
        BigDecimal freeShippingThreshold,
        String contactEmail,
        String contactPhone
) {}
