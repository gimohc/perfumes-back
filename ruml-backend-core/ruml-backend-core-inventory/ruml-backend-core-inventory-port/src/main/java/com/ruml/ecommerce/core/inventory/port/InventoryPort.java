package com.ruml.ecommerce.core.inventory.port;

import com.ruml.ecommerce.core.inventory.entity.InventoryItemEntity;
import com.ruml.ecommerce.core.inventory.entity.InventoryItemId;
import java.util.Optional;

public interface InventoryPort {
    InventoryItemEntity save(InventoryItemEntity item);
    Optional<InventoryItemEntity> findById(InventoryItemId id);
    Optional<InventoryItemEntity> findByPerfumeId(String perfumeId);
}
