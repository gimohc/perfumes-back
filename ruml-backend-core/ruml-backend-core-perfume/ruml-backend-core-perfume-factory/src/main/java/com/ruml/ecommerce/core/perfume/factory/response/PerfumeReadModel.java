package com.ruml.ecommerce.core.perfume.factory.response;

import java.math.BigDecimal;

public record PerfumeReadModel(
    String id,
    String name,
    BigDecimal price,
    String topNotes,
    String heartNotes,
    String baseNotes,
    boolean inStock
) {}
