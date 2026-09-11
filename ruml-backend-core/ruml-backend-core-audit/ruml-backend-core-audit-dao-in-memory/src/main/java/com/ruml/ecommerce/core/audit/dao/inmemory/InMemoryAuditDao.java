package com.ruml.ecommerce.core.audit.dao.inmemory;

import com.ruml.ecommerce.core.audit.dao.AuditDao;
import com.ruml.ecommerce.core.audit.entity.AuditEntity;
import com.ruml.ecommerce.core.audit.identity.AuditId;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class InMemoryAuditDao implements AuditDao {
    private final Map<AuditId, AuditEntity> store = new ConcurrentHashMap<>();

    @Override
    public Optional<AuditEntity> findById(AuditId id) {
        return Optional.ofNullable(store.get(id));
    }
    
    public void save(AuditEntity entity) {
        store.put(entity.getId(), entity);
    }
}
