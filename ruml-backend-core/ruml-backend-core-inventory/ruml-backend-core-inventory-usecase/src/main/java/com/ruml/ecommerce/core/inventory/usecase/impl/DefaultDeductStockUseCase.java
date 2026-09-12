package com.ruml.ecommerce.core.inventory.usecase.impl;

import com.ruml.ecommerce.core.inventory.entity.InventoryItemEntity;
import com.ruml.ecommerce.core.inventory.factory.request.DeductStockRequest;
import com.ruml.ecommerce.core.inventory.factory.response.DeductStockResponse;
import com.ruml.ecommerce.core.inventory.port.InventoryPort;
import com.ruml.ecommerce.core.inventory.usecase.DeductStockUseCase;
import com.ruml.ecommerce.core.shared.exception.DomainException;

public class DefaultDeductStockUseCase implements DeductStockUseCase {

    private final InventoryPort inventoryPort;

    public DefaultDeductStockUseCase(InventoryPort inventoryPort) {
        this.inventoryPort = inventoryPort;
    }

    @Override
    public DeductStockResponse execute(DeductStockRequest request) {
        InventoryItemEntity item = inventoryPort.findByPerfumeId(request.perfumeId())
            .orElseThrow(() -> new DomainException("INVENTORY_NOT_FOUND", "No inventory record found for perfume " + request.perfumeId()));
            
        item.deduct(request.quantity());
        InventoryItemEntity saved = inventoryPort.save(item);
        
        return new DeductStockResponse(saved.getId().value(), saved.getTotalStock(), saved.getReservedStock());
    }
}
