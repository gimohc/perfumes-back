package com.ruml.ecommerce.core.perfume.factory.request;

import java.math.BigDecimal;

public record CreatePerfumeRequest(
    String name,
    BigDecimal price,
    String topNotes,
    String heartNotes,
    String baseNotes,
    int volumeMilliliters,
    String concentration,
    int initialStock
) {}
