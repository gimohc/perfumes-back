package com.ruml.ecommerce.core.order.identity;
import com.ruml.ecommerce.core.shared.identity.Identity;
import java.math.BigDecimal;
import java.util.List;
public interface OrderIdentity extends Identity {
    String orderId();
    String customerName();
    String customerEmail();
    String customerPhone();
    String shippingAddress();
    String paymentMethod();
    BigDecimal subtotal();
    BigDecimal shippingFee();
    BigDecimal total();
    String status();
    List<? extends OrderItemIdentity> items();
}
