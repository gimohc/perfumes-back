package com.ruml.ecommerce.core.store.port;

import com.ruml.ecommerce.core.store.entity.readmodel.StoreReadModel;
import com.ruml.ecommerce.core.store.identity.StoreId;
import java.util.Optional;

public interface StoreReadPort {
    Optional<StoreReadModel> findById(StoreId id);
}
