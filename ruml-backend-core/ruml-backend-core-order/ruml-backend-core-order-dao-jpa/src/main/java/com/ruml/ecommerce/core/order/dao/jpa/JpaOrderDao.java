package com.ruml.ecommerce.core.order.dao.jpa;

import com.ruml.ecommerce.core.order.dao.OrderDao;
import com.ruml.ecommerce.core.order.entity.OrderEntity;
import com.ruml.ecommerce.core.order.identity.OrderId;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class JpaOrderDao implements OrderDao {
    private final OrderRepository repository;

    public JpaOrderDao(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<OrderEntity> findById(OrderId id) {
        return repository.findById(id);
    }
}
