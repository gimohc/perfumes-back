package com.ruml.ecommerce.core.order.factory.request;
import java.math.BigDecimal;
import java.util.List;
public record PlaceOrderRequest(
    CustomerDto customer,
    List<OrderItemDto> items,
    String paymentMethod,
    BigDecimal subtotal,
    BigDecimal shipping,
    BigDecimal total
) {
    public record CustomerDto(String name, String email, String phone, String address, String city, String country) {}
    public record OrderItemDto(String id, String type, String name, BigDecimal price, int quantity) {}
}
