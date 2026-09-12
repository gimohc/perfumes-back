package com.ruml.ecommerce.core.inventory.usecase;

import com.ruml.ecommerce.core.inventory.factory.request.ReleaseStockRequest;
import com.ruml.ecommerce.core.inventory.factory.response.ReleaseStockResponse;
import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;

public interface ReleaseStockUseCase extends FunctionalUseCase<ReleaseStockRequest, ReleaseStockResponse> {}
