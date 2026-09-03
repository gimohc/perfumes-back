package com.ruml.ecommerce.core.audit.dao;
import com.ruml.ecommerce.core.shared.dao.Creator;
import com.ruml.ecommerce.core.audit.identity.AuditLogIdentity;
public interface AuditLogCreator extends Creator<AuditLogIdentity> {
    AuditLogCreator adminName(String v); AuditLogCreator role(String v);
    AuditLogCreator actionEn(String v); AuditLogCreator actionAr(String v);
    AuditLogCreator targetEn(String v); AuditLogCreator targetAr(String v);
    AuditLogCreator type(String v);
}
