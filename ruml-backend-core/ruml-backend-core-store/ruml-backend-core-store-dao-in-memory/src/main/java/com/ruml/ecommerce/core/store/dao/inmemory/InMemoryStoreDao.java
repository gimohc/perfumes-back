package com.ruml.ecommerce.core.store.dao.inmemory;

import com.ruml.ecommerce.core.store.dao.StoreDao;
import com.ruml.ecommerce.core.store.entity.StoreEntity;
import com.ruml.ecommerce.core.store.identity.StoreId;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class InMemoryStoreDao implements StoreDao {
    private final Map<StoreId, StoreEntity> store = new ConcurrentHashMap<>();

    @Override
    public Optional<StoreEntity> findById(StoreId id) {
        return Optional.ofNullable(store.get(id));
    }
    
    public void save(StoreEntity entity) {
        store.put(entity.getId(), entity);
    }
}
