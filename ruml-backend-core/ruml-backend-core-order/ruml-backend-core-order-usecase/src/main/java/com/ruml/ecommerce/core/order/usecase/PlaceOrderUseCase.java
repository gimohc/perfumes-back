package com.ruml.ecommerce.core.order.usecase;

import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;
import com.ruml.ecommerce.core.order.factory.request.PlaceOrderRequest;
import com.ruml.ecommerce.core.order.factory.response.PlaceOrderResponse;

public interface PlaceOrderUseCase extends FunctionalUseCase<PlaceOrderRequest, PlaceOrderResponse> {
}
