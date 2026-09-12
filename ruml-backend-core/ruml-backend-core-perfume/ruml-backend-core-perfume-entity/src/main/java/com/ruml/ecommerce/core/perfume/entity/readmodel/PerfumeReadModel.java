package com.ruml.ecommerce.core.perfume.entity.readmodel;

import java.math.BigDecimal;

public record PerfumeReadModel(
    String id,
    String name,
    BigDecimal price,
    String topNotes,
    String heartNotes,
    String baseNotes,
    int volumeMl,
    String concentration,
    boolean inStock
) {}
