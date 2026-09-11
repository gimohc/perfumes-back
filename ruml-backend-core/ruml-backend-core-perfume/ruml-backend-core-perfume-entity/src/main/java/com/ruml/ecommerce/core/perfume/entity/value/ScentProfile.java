package com.ruml.ecommerce.core.perfume.entity.value;

import jakarta.persistence.Embeddable;

@Embeddable
public record ScentProfile(
    String topNotes,
    String heartNotes,
    String baseNotes
) {
    public ScentProfile {
        if (topNotes == null || topNotes.isBlank()) throw new IllegalArgumentException("Top notes required");
        if (heartNotes == null || heartNotes.isBlank()) throw new IllegalArgumentException("Heart notes required");
        if (baseNotes == null || baseNotes.isBlank()) throw new IllegalArgumentException("Base notes required");
    }
}
