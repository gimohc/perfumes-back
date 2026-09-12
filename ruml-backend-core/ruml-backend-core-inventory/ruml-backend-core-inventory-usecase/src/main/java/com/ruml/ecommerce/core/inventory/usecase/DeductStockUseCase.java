package com.ruml.ecommerce.core.inventory.usecase;

import com.ruml.ecommerce.core.inventory.factory.request.DeductStockRequest;
import com.ruml.ecommerce.core.inventory.factory.response.DeductStockResponse;
import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;

public interface DeductStockUseCase extends FunctionalUseCase<DeductStockRequest, DeductStockResponse> {}
