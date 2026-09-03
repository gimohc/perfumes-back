package com.ruml.ecommerce.core.audit.entity;
import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.audit.identity.AuditLogIdentity;
public class AuditLogEntity extends Entity implements AuditLogIdentity {
    private String adminName, role, actionEn, actionAr, targetEn, targetAr, type;
    @Override public String adminName() { return adminName; }
    @Override public String role() { return role; }
    @Override public String actionEn() { return actionEn; }
    @Override public String actionAr() { return actionAr; }
    @Override public String targetEn() { return targetEn; }
    @Override public String targetAr() { return targetAr; }
    @Override public String type() { return type; }
}
