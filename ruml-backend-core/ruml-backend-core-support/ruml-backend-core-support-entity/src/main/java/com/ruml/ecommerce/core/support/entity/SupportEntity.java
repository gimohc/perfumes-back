package com.ruml.ecommerce.core.support.entity;

import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.support.identity.SupportId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "supports")
public class SupportEntity implements Entity<SupportId> {
    
    @EmbeddedId
    private SupportId id;

    protected SupportEntity() {
        // JPA requires default constructor
    }

    public SupportEntity(SupportId id) {
        this.id = id;
    }

    @Override
    public SupportId getId() {
        return id;
    }
}
