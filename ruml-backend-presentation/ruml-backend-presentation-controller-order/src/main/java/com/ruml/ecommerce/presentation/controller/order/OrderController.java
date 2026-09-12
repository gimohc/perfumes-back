package com.ruml.ecommerce.presentation.controller.order;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import com.ruml.ecommerce.core.order.factory.request.SubmitOrderRequest;
import com.ruml.ecommerce.core.order.factory.request.ListOrdersRequest;
import com.ruml.ecommerce.core.order.factory.response.OrderResponse;
import com.ruml.ecommerce.core.order.factory.response.ListOrdersResponse;
import com.ruml.ecommerce.core.order.usecase.SubmitOrderCommand;
import com.ruml.ecommerce.core.order.usecase.ListOrdersQuery;
import com.ruml.ecommerce.core.shared.entity.pagination.PageQuery;

@RestController
@Tag(name = "Order", description = "Order management API")
@RequestMapping("/api/orders")
public class OrderController {

    private final SubmitOrderCommand submitOrderCommand;
    private final ListOrdersQuery listOrdersQuery;

    public OrderController(SubmitOrderCommand submitOrderCommand, ListOrdersQuery listOrdersQuery) {
        this.submitOrderCommand = submitOrderCommand;
        this.listOrdersQuery = listOrdersQuery;
    }

    @PostMapping
    @Operation(summary = "Submit a new order")
    public ResponseEntity<OrderResponse> submitOrder(@RequestBody SubmitOrderRequest request) {
        OrderResponse response = submitOrderCommand.execute(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/admin")
    @Operation(summary = "List all orders (Admin only)")
    public ResponseEntity<ListOrdersResponse> listOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "DESC") String sortDirection) {
        
        PageQuery query = new PageQuery(page, size, sortBy, sortDirection);
        ListOrdersResponse response = listOrdersQuery.execute(new ListOrdersRequest(query));
        return ResponseEntity.ok(response);
    }
}
