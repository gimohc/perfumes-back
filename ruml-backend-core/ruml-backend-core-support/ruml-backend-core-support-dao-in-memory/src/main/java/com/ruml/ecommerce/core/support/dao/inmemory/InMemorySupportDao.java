package com.ruml.ecommerce.core.support.dao.inmemory;

import com.ruml.ecommerce.core.support.dao.SupportDao;
import com.ruml.ecommerce.core.support.entity.SupportEntity;
import com.ruml.ecommerce.core.support.identity.SupportId;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class InMemorySupportDao implements SupportDao {
    private final Map<SupportId, SupportEntity> store = new ConcurrentHashMap<>();

    @Override
    public Optional<SupportEntity> findById(SupportId id) {
        return Optional.ofNullable(store.get(id));
    }
    
    public void save(SupportEntity entity) {
        store.put(entity.getId(), entity);
    }
}
