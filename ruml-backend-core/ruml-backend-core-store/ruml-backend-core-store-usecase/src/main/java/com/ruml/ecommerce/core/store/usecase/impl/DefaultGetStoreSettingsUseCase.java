package com.ruml.ecommerce.core.store.usecase.impl;

import com.ruml.ecommerce.core.store.factory.request.GetStoreSettingsRequest;
import com.ruml.ecommerce.core.store.factory.response.GetStoreSettingsResponse;
import com.ruml.ecommerce.core.store.port.StoreReadPort;
import com.ruml.ecommerce.core.store.identity.StoreId;
import com.ruml.ecommerce.core.store.usecase.GetStoreSettingsUseCase;
import com.ruml.ecommerce.core.shared.exception.DomainException;

public class DefaultGetStoreSettingsUseCase implements GetStoreSettingsUseCase {

    private final StoreReadPort storeReadPort;

    public DefaultGetStoreSettingsUseCase(StoreReadPort storeReadPort) {
        this.storeReadPort = storeReadPort;
    }

    @Override
    public GetStoreSettingsResponse execute(GetStoreSettingsRequest request) {
        var store = storeReadPort.findById(new StoreId(request.storeId()))
            .orElseThrow(() -> new DomainException("STORE_NOT_FOUND", "Store not found"));
        return new GetStoreSettingsResponse(store);
    }
}
