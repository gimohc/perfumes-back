package com.ruml.ecommerce.core.audit.dao;

import com.ruml.ecommerce.core.shared.dao.Dao;
import com.ruml.ecommerce.core.audit.entity.AuditEntity;
import com.ruml.ecommerce.core.audit.identity.AuditId;

public interface AuditDao extends Dao<AuditEntity, AuditId> {
}
