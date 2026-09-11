package com.ruml.ecommerce.core.audit.dao.jpa;

import com.ruml.ecommerce.core.audit.entity.AuditEntity;
import com.ruml.ecommerce.core.audit.identity.AuditId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<AuditEntity, AuditId> {
}
