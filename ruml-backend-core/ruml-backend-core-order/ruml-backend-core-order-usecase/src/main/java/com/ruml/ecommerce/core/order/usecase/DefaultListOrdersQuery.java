package com.ruml.ecommerce.core.order.usecase;

import com.ruml.ecommerce.core.order.factory.request.ListOrdersRequest;
import com.ruml.ecommerce.core.order.factory.response.ListOrdersResponse;
import com.ruml.ecommerce.core.order.port.OrderReadPort;
import com.ruml.ecommerce.core.order.entity.readmodel.OrderReadModel;
import com.ruml.ecommerce.core.shared.entity.pagination.PageResult;

public class DefaultListOrdersQuery implements ListOrdersQuery {

    private final OrderReadPort orderReadPort;

    public DefaultListOrdersQuery(OrderReadPort orderReadPort) {
        this.orderReadPort = orderReadPort;
    }

    @Override
    public ListOrdersResponse execute(ListOrdersRequest input) {
        PageResult<OrderReadModel> page = orderReadPort.findOrders(input.query());
        return new ListOrdersResponse(page);
    }
}
