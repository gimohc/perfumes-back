package com.ruml.ecommerce.core.audit.dao;
import com.ruml.ecommerce.core.shared.dao.Dao;
import com.ruml.ecommerce.core.audit.identity.AuditLogIdentity;
import java.util.List;
public interface AuditLogDao extends Dao<AuditLogIdentity, AuditLogCreator, AuditLogUpdater> {
    List<AuditLogIdentity> findAll();
}
