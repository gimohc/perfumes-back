package com.ruml.ecommerce.core.order.port;

import com.ruml.ecommerce.core.order.entity.readmodel.OrderReadModel;
import com.ruml.ecommerce.core.shared.entity.pagination.PageQuery;
import com.ruml.ecommerce.core.shared.entity.pagination.PageResult;
import com.ruml.ecommerce.core.order.identity.OrderId;

import java.util.Optional;

public interface OrderReadPort {
    PageResult<OrderReadModel> findOrders(PageQuery query);
    Optional<OrderReadModel> findById(OrderId id);
}
