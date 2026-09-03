package com.ruml.ecommerce.core.order.dao;
import com.ruml.ecommerce.core.shared.dao.Dao;
import com.ruml.ecommerce.core.order.identity.OrderIdentity;
import java.util.List;
import java.util.Optional;
public interface OrderDao extends Dao<OrderIdentity, OrderCreator, OrderUpdater> {
    Optional<OrderIdentity> findByOrderId(String orderId);
    List<OrderIdentity> findAll();
}
