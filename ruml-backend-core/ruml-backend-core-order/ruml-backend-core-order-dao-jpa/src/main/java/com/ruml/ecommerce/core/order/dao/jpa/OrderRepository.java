package com.ruml.ecommerce.core.order.dao.jpa;

import com.ruml.ecommerce.core.order.entity.OrderEntity;
import com.ruml.ecommerce.core.order.identity.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, OrderId> {
}
