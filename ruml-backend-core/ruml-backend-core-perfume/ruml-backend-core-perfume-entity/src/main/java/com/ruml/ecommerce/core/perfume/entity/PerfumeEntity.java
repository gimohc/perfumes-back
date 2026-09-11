package com.ruml.ecommerce.core.perfume.entity;

import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.perfume.identity.PerfumeId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "perfumes")
public class PerfumeEntity implements Entity<PerfumeId> {
    
    @EmbeddedId
    private PerfumeId id;

    protected PerfumeEntity() {
        // JPA requires default constructor
    }

    public PerfumeEntity(PerfumeId id) {
        this.id = id;
    }

    @Override
    public PerfumeId getId() {
        return id;
    }
}
