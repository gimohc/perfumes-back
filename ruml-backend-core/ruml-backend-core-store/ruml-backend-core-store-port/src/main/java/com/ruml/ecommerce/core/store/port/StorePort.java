package com.ruml.ecommerce.core.store.port;

import com.ruml.ecommerce.core.store.entity.StoreEntity;
import com.ruml.ecommerce.core.store.identity.StoreId;
import java.util.Optional;

public interface StorePort {
    Optional<StoreEntity> findById(StoreId id);
    StoreEntity save(StoreEntity store);
}
