package com.ruml.ecommerce.core.perfume.dao.inmemory;

import com.ruml.ecommerce.core.perfume.dao.PerfumeDao;
import com.ruml.ecommerce.core.perfume.entity.PerfumeEntity;
import com.ruml.ecommerce.core.perfume.identity.PerfumeId;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class InMemoryPerfumeDao implements PerfumeDao {
    private final Map<PerfumeId, PerfumeEntity> store = new ConcurrentHashMap<>();

    @Override
    public Optional<PerfumeEntity> findById(PerfumeId id) {
        return Optional.ofNullable(store.get(id));
    }
    
    public void save(PerfumeEntity entity) {
        store.put(entity.getId(), entity);
    }
}
