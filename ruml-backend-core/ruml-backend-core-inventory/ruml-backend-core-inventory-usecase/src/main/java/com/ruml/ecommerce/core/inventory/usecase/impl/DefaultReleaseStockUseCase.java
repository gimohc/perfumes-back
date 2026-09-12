package com.ruml.ecommerce.core.inventory.usecase.impl;

import com.ruml.ecommerce.core.inventory.entity.InventoryItemEntity;
import com.ruml.ecommerce.core.inventory.factory.request.ReleaseStockRequest;
import com.ruml.ecommerce.core.inventory.factory.response.ReleaseStockResponse;
import com.ruml.ecommerce.core.inventory.port.InventoryPort;
import com.ruml.ecommerce.core.inventory.usecase.ReleaseStockUseCase;
import com.ruml.ecommerce.core.shared.exception.DomainException;

public class DefaultReleaseStockUseCase implements ReleaseStockUseCase {

    private final InventoryPort inventoryPort;

    public DefaultReleaseStockUseCase(InventoryPort inventoryPort) {
        this.inventoryPort = inventoryPort;
    }

    @Override
    public ReleaseStockResponse execute(ReleaseStockRequest request) {
        InventoryItemEntity item = inventoryPort.findByPerfumeId(request.perfumeId())
            .orElseThrow(() -> new DomainException("INVENTORY_NOT_FOUND", "No inventory record found for perfume " + request.perfumeId()));
            
        item.releaseReservation(request.quantity());
        InventoryItemEntity saved = inventoryPort.save(item);
        
        return new ReleaseStockResponse(saved.getId().value(), saved.getReservedStock());
    }
}
