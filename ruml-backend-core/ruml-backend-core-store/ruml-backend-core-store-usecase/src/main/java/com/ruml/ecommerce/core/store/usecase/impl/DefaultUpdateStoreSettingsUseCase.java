package com.ruml.ecommerce.core.store.usecase.impl;

import com.ruml.ecommerce.core.store.factory.request.UpdateStoreSettingsRequest;
import com.ruml.ecommerce.core.store.factory.response.UpdateStoreSettingsResponse;
import com.ruml.ecommerce.core.store.port.StorePort;
import com.ruml.ecommerce.core.store.entity.StoreEntity;
import com.ruml.ecommerce.core.store.identity.StoreId;
import com.ruml.ecommerce.core.store.usecase.UpdateStoreSettingsUseCase;
import com.ruml.ecommerce.core.shared.exception.DomainException;
import com.ruml.ecommerce.core.store.entity.readmodel.StoreReadModel;

public class DefaultUpdateStoreSettingsUseCase implements UpdateStoreSettingsUseCase {

    private final StorePort storePort;

    public DefaultUpdateStoreSettingsUseCase(StorePort storePort) {
        this.storePort = storePort;
    }

    @Override
    public UpdateStoreSettingsResponse execute(UpdateStoreSettingsRequest request) {
        StoreEntity store = storePort.findById(new StoreId(request.storeId()))
            .orElseThrow(() -> new DomainException("STORE_NOT_FOUND", "Store not found"));
            
        store.updateSettings(
            request.currency(),
            request.minimumOrderQuantity(),
            request.freeShippingThreshold(),
            request.contactEmail(),
            request.contactPhone()
        );
        
        StoreEntity saved = storePort.save(store);
        StoreReadModel readModel = new StoreReadModel(
            saved.getId().getValue(),
            saved.getCurrency(),
            saved.getMinimumOrderQuantity(),
            saved.getFreeShippingThreshold(),
            saved.getContactEmail(),
            saved.getContactPhone()
        );
        
        return new UpdateStoreSettingsResponse(readModel);
    }
}
