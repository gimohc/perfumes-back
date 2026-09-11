package com.ruml.ecommerce.core.order.dao;

import com.ruml.ecommerce.core.shared.dao.Dao;
import com.ruml.ecommerce.core.order.entity.OrderEntity;
import com.ruml.ecommerce.core.order.identity.OrderId;

public interface OrderDao extends Dao<OrderEntity, OrderId> {
}
