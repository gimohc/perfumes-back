package com.ruml.ecommerce.core.order.dao.jpa;
import com.ruml.ecommerce.core.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface OrderRepository extends JpaRepository<OrderEntity, String> {
    Optional<OrderEntity> findByOrderId(String orderId);
}
