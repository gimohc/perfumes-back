package com.ruml.ecommerce.core.inventory.usecase;

import com.ruml.ecommerce.core.inventory.factory.request.ReserveStockRequest;
import com.ruml.ecommerce.core.inventory.factory.response.ReserveStockResponse;
import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;

public interface ReserveStockUseCase extends FunctionalUseCase<ReserveStockRequest, ReserveStockResponse> {}
