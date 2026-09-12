package com.ruml.ecommerce.core.inventory.usecase.impl;

import com.ruml.ecommerce.core.inventory.entity.InventoryItemEntity;
import com.ruml.ecommerce.core.inventory.factory.request.ReserveStockRequest;
import com.ruml.ecommerce.core.inventory.factory.response.ReserveStockResponse;
import com.ruml.ecommerce.core.inventory.port.InventoryPort;
import com.ruml.ecommerce.core.inventory.usecase.ReserveStockUseCase;
import com.ruml.ecommerce.core.shared.exception.DomainException;

public class DefaultReserveStockUseCase implements ReserveStockUseCase {

    private final InventoryPort inventoryPort;

    public DefaultReserveStockUseCase(InventoryPort inventoryPort) {
        this.inventoryPort = inventoryPort;
    }

    @Override
    public ReserveStockResponse execute(ReserveStockRequest request) {
        InventoryItemEntity item = inventoryPort.findByPerfumeId(request.perfumeId())
            .orElseThrow(() -> new DomainException("INVENTORY_NOT_FOUND", "No inventory record found for perfume " + request.perfumeId()));
            
        item.reserve(request.quantity());
        InventoryItemEntity saved = inventoryPort.save(item);
        
        return new ReserveStockResponse(saved.getId().value(), saved.getReservedStock());
    }
}
