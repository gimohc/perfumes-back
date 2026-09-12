package com.ruml.ecommerce.core.order.usecase;

import com.ruml.ecommerce.core.order.factory.request.SubmitOrderRequest;
import com.ruml.ecommerce.core.order.factory.response.OrderResponse;
import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;

public interface SubmitOrderCommand extends FunctionalUseCase<SubmitOrderRequest, OrderResponse> {
}
