package com.ruml.ecommerce.presentation.controller.store;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import com.ruml.ecommerce.core.store.factory.request.GetStoreSettingsRequest;
import com.ruml.ecommerce.core.store.factory.request.UpdateStoreSettingsRequest;
import com.ruml.ecommerce.core.store.factory.response.GetStoreSettingsResponse;
import com.ruml.ecommerce.core.store.factory.response.UpdateStoreSettingsResponse;
import com.ruml.ecommerce.core.store.usecase.GetStoreSettingsUseCase;
import com.ruml.ecommerce.core.store.usecase.UpdateStoreSettingsUseCase;

@RestController
@Tag(name = "Store", description = "Store Settings API")
@RequestMapping("/api/settings/store")
public class StoreController {

    private final GetStoreSettingsUseCase getStoreSettingsUseCase;
    private final UpdateStoreSettingsUseCase updateStoreSettingsUseCase;

    public StoreController(GetStoreSettingsUseCase getStoreSettingsUseCase, UpdateStoreSettingsUseCase updateStoreSettingsUseCase) {
        this.getStoreSettingsUseCase = getStoreSettingsUseCase;
        this.updateStoreSettingsUseCase = updateStoreSettingsUseCase;
    }

    @GetMapping
    @Operation(summary = "Get store settings")
    public ResponseEntity<GetStoreSettingsResponse> getStoreSettings() {
        // Hardcoded store ID for single-store setup for now
        GetStoreSettingsResponse response = getStoreSettingsUseCase.execute(new GetStoreSettingsRequest("default-store"));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "Update store settings")
    public ResponseEntity<UpdateStoreSettingsResponse> updateStoreSettings(@RequestBody UpdateStoreSettingsRequest request) {
        UpdateStoreSettingsResponse response = updateStoreSettingsUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}
