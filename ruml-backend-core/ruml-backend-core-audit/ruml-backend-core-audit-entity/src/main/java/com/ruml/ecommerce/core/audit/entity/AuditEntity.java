package com.ruml.ecommerce.core.audit.entity;

import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.audit.identity.AuditId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@jakarta.persistence.Entity
@Table(name = "audit_logs")
public class AuditEntity implements Entity<AuditId> {
    
    @EmbeddedId
    private AuditId id;

    @Column(nullable = false)
    private String adminId;

    @Column(nullable = false)
    private String action;

    @Column(nullable = false)
    private String resource;

    @Column(nullable = false)
    private java.time.Instant timestamp;

    protected AuditEntity() {
        // JPA requires default constructor
    }

    public AuditEntity(AuditId id, String adminId, String action, String resource) {
        this.id = id;
        this.adminId = adminId;
        this.action = action;
        this.resource = resource;
        this.timestamp = java.time.Instant.now();
    }

    @Override
    public AuditId getId() {
        return id;
    }

    public String getAdminId() { return adminId; }
    public String getAction() { return action; }
    public String getResource() { return resource; }
    public java.time.Instant getTimestamp() { return timestamp; }
}
