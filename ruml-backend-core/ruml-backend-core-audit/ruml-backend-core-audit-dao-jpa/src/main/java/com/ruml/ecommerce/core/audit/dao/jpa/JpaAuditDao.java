package com.ruml.ecommerce.core.audit.dao.jpa;

import com.ruml.ecommerce.core.audit.dao.AuditDao;
import com.ruml.ecommerce.core.audit.entity.AuditEntity;
import com.ruml.ecommerce.core.audit.identity.AuditId;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class JpaAuditDao implements AuditDao {
    private final AuditRepository repository;

    public JpaAuditDao(AuditRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<AuditEntity> findById(AuditId id) {
        return repository.findById(id);
    }
}
