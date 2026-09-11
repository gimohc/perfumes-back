package com.ruml.ecommerce.core.order.dao.inmemory;

import com.ruml.ecommerce.core.order.dao.OrderDao;
import com.ruml.ecommerce.core.order.entity.OrderEntity;
import com.ruml.ecommerce.core.order.identity.OrderId;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class InMemoryOrderDao implements OrderDao {
    private final Map<OrderId, OrderEntity> store = new ConcurrentHashMap<>();

    @Override
    public Optional<OrderEntity> findById(OrderId id) {
        return Optional.ofNullable(store.get(id));
    }
    
    public void save(OrderEntity entity) {
        store.put(entity.getId(), entity);
    }
}
