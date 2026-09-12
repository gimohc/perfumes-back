package com.ruml.ecommerce.core.order.entity.readmodel;

import com.ruml.ecommerce.core.order.entity.OrderItem;
import com.ruml.ecommerce.core.order.entity.OrderStatus;

import java.math.BigDecimal;
import java.util.List;

public record OrderReadModel(
        String orderId,
        String customerId,
        OrderStatus status,
        List<OrderItem> items,
        BigDecimal subtotal,
        BigDecimal tax,
        BigDecimal total
) {}
