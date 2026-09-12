package com.ruml.ecommerce.core.order.port;

import com.ruml.ecommerce.core.order.entity.OrderEntity;
import com.ruml.ecommerce.core.order.identity.OrderId;
import java.util.Optional;

public interface OrderPort {
    void save(OrderEntity order);
    Optional<OrderEntity> findById(OrderId id);
}
