package com.ruml.ecommerce.presentation.controller.order;
import com.ruml.ecommerce.core.order.usecase.main.PlaceOrderUseCase;
import com.ruml.ecommerce.core.order.usecase.main.ResolveOrderUseCase;
import com.ruml.ecommerce.core.order.factory.request.PlaceOrderRequest;
import com.ruml.ecommerce.core.order.factory.response.PlaceOrderResponse;
import com.ruml.ecommerce.core.order.factory.request.ResolveOrderRequest;
import com.ruml.ecommerce.core.order.factory.response.ResolveOrderResponse;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class OrderController {
    private final PlaceOrderUseCase placeOrderUseCase;
    private final ResolveOrderUseCase resolveOrderUseCase;
    public OrderController(PlaceOrderUseCase placeOrderUseCase, ResolveOrderUseCase resolveOrderUseCase) {
        this.placeOrderUseCase = placeOrderUseCase;
        this.resolveOrderUseCase = resolveOrderUseCase;
    }
    @PostMapping("/orders")
    public PlaceOrderResponse placeOrder(@RequestBody PlaceOrderRequest request) {
        return placeOrderUseCase.execute(request);
    }
    @PostMapping("/admin/orders/{id}/resolve")
    public ResolveOrderResponse resolveOrder(@PathVariable("id") String orderId, @RequestBody ResolveOrderRequest request) {
        // Map path variable into request if needed, or construct new request
        var fullRequest = new ResolveOrderRequest(orderId, request.status());
        return resolveOrderUseCase.execute(fullRequest);
    }
}
