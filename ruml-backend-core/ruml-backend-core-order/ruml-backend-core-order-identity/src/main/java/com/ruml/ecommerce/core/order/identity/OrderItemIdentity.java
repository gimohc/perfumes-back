package com.ruml.ecommerce.core.order.identity;
import com.ruml.ecommerce.core.shared.identity.Identity;
import java.math.BigDecimal;
public interface OrderItemIdentity extends Identity {
    String itemId();
    String itemType();
    String name();
    BigDecimal price();
    int quantity();
}
