package com.ruml.ecommerce.core.audit.entity;

import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.audit.identity.AuditId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "audits")
public class AuditEntity implements Entity<AuditId> {
    
    @EmbeddedId
    private AuditId id;

    protected AuditEntity() {
        // JPA requires default constructor
    }

    public AuditEntity(AuditId id) {
        this.id = id;
    }

    @Override
    public AuditId getId() {
        return id;
    }
}
