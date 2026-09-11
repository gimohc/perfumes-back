package com.ruml.ecommerce.core.auth.dao.inmemory;

import com.ruml.ecommerce.core.auth.dao.AuthDao;
import com.ruml.ecommerce.core.auth.entity.AuthEntity;
import com.ruml.ecommerce.core.auth.identity.AuthId;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class InMemoryAuthDao implements AuthDao {
    private final Map<AuthId, AuthEntity> store = new ConcurrentHashMap<>();

    @Override
    public Optional<AuthEntity> findById(AuthId id) {
        return Optional.ofNullable(store.get(id));
    }
    
    public void save(AuthEntity entity) {
        store.put(entity.getId(), entity);
    }
}
