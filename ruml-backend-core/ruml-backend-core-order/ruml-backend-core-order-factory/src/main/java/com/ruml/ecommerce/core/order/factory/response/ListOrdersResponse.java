package com.ruml.ecommerce.core.order.factory.response;

import com.ruml.ecommerce.core.order.entity.readmodel.OrderReadModel;
import com.ruml.ecommerce.core.shared.entity.pagination.PageResult;

public record ListOrdersResponse(PageResult<OrderReadModel> page) {}
