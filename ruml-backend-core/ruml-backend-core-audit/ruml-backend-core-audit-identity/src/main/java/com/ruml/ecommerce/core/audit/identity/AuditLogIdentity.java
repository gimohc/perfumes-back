package com.ruml.ecommerce.core.audit.identity;
import com.ruml.ecommerce.core.shared.identity.Identity;
public interface AuditLogIdentity extends Identity {
    String adminName();
    String role();
    String actionEn();
    String actionAr();
    String targetEn();
    String targetAr();
    String type();
}
