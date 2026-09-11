package com.ruml.ecommerce.core.store.dao.jpa;

import com.ruml.ecommerce.core.store.dao.StoreDao;
import com.ruml.ecommerce.core.store.entity.StoreEntity;
import com.ruml.ecommerce.core.store.identity.StoreId;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class JpaStoreDao implements StoreDao {
    private final StoreRepository repository;

    public JpaStoreDao(StoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<StoreEntity> findById(StoreId id) {
        return repository.findById(id);
    }
}
