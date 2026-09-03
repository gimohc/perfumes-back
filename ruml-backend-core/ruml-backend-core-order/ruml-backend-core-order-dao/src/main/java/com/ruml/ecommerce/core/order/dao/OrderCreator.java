package com.ruml.ecommerce.core.order.dao;
import com.ruml.ecommerce.core.shared.dao.Creator;
import com.ruml.ecommerce.core.order.identity.OrderIdentity;
public interface OrderCreator extends Creator<OrderIdentity> {
    OrderCreator orderId(String orderId);
    OrderCreator customerName(String customerName);
    OrderCreator customerEmail(String customerEmail);
    OrderCreator customerPhone(String customerPhone);
    OrderCreator shippingAddress(String shippingAddress);
    OrderCreator paymentMethod(String paymentMethod);
    OrderCreator subtotal(java.math.BigDecimal subtotal);
    OrderCreator shippingFee(java.math.BigDecimal shippingFee);
    OrderCreator total(java.math.BigDecimal total);
    OrderCreator status(String status);
    OrderCreator addItem(String itemId, String itemType, String name, java.math.BigDecimal price, int quantity);
}
