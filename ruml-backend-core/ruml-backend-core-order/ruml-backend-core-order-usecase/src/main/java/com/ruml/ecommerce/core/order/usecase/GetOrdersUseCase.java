package com.ruml.ecommerce.core.order.usecase;

import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;
import com.ruml.ecommerce.core.order.factory.request.GetOrdersRequest;
import com.ruml.ecommerce.core.order.factory.response.GetOrdersResponse;

public interface GetOrdersUseCase extends FunctionalUseCase<GetOrdersRequest, GetOrdersResponse> {
}
