package com.ruml.ecommerce.core.audit.port;

import com.ruml.ecommerce.core.audit.entity.AuditEntity;
import com.ruml.ecommerce.core.audit.identity.AuditId;
import java.util.Optional;

public interface AuditPort {
    Optional<AuditEntity> findById(AuditId id);
    AuditEntity save(AuditEntity audit);
}
