package com.ruml.ecommerce.core.order.factory.request;

import java.util.List;

public record SubmitOrderRequest(
        String customerId,
        List<CartItemRequest> items
) {
    public record CartItemRequest(String perfumeId, int quantity) {}
}
