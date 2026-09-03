package com.ruml.ecommerce.core.order.dao.jpa;
import com.ruml.ecommerce.core.order.dao.OrderDao;
import com.ruml.ecommerce.core.order.dao.OrderCreator;
import com.ruml.ecommerce.core.order.dao.OrderUpdater;
import com.ruml.ecommerce.core.order.identity.OrderIdentity;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
public class JpaOrderDao implements OrderDao {
    private final OrderRepository repository;
    public JpaOrderDao(OrderRepository repository) { this.repository = repository; }
    @Override
    public Optional<OrderIdentity> findByOrderId(String orderId) {
        return repository.findByOrderId(orderId).map(e -> (OrderIdentity) e);
    }
    @Override
    public List<OrderIdentity> findAll() {
        return repository.findAll().stream().map(e -> (OrderIdentity) e).collect(Collectors.toList());
    }
    @Override
    public OrderCreator creator() {
        return null; // Implementation omitted
    }
    @Override
    public OrderUpdater updater(OrderIdentity identity) {
        return null; // Implementation omitted
    }
}
