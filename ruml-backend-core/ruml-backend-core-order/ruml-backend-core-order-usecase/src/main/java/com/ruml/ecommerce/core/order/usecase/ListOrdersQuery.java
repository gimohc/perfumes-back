package com.ruml.ecommerce.core.order.usecase;

import com.ruml.ecommerce.core.order.factory.request.ListOrdersRequest;
import com.ruml.ecommerce.core.order.factory.response.ListOrdersResponse;
import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;

public interface ListOrdersQuery extends FunctionalUseCase<ListOrdersRequest, ListOrdersResponse> {
}
