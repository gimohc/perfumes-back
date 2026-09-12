package com.ruml.ecommerce.core.audit.entity.readmodel;

public record AuditReadModel(
    String id,
    String adminId,
    String action,
    String resource,
    java.time.Instant timestamp
) {}
