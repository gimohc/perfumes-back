package com.ruml.ecommerce.core.order.usecase;

import com.ruml.ecommerce.core.order.entity.OrderEntity;
import com.ruml.ecommerce.core.order.entity.OrderItem;
import com.ruml.ecommerce.core.order.entity.readmodel.OrderReadModel;
import com.ruml.ecommerce.core.order.factory.request.SubmitOrderRequest;
import com.ruml.ecommerce.core.order.factory.response.OrderResponse;
import com.ruml.ecommerce.core.order.identity.OrderId;
import com.ruml.ecommerce.core.order.port.OrderPort;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DefaultSubmitOrderCommand implements SubmitOrderCommand {

    private final OrderPort orderPort;

    public DefaultSubmitOrderCommand(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @Override
    public OrderResponse execute(SubmitOrderRequest input) {
        List<OrderItem> items = input.items().stream()
                .map(req -> new OrderItem(req.perfumeId(), req.quantity(), BigDecimal.valueOf(100.0))) // Dummy price for now
                .collect(Collectors.toList());

        OrderEntity order = new OrderEntity(
                new OrderId(UUID.randomUUID().toString()),
                input.customerId(),
                items,
                BigDecimal.valueOf(0.15) // 15% tax
        );

        orderPort.save(order);
        
        OrderReadModel readModel = new OrderReadModel(
            order.getId().getValue(),
            order.getCustomerId(),
            order.getStatus(),
            order.getItems(),
            order.getSubtotal(),
            order.getTax(),
            order.getTotal()
        );
        return new OrderResponse(readModel);
    }
}
