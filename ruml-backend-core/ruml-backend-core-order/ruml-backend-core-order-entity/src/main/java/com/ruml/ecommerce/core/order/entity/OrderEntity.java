package com.ruml.ecommerce.core.order.entity;
import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.order.identity.OrderIdentity;
import com.ruml.ecommerce.core.order.identity.OrderItemIdentity;
import java.math.BigDecimal;
import java.util.List;
public class OrderEntity extends Entity implements OrderIdentity {
    private String orderId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String shippingAddress;
    private String paymentMethod;
    private BigDecimal subtotal;
    private BigDecimal shippingFee;
    private BigDecimal total;
    private String status;
    private List<? extends OrderItemIdentity> items;
    @Override public String orderId() { return orderId; }
    @Override public String customerName() { return customerName; }
    @Override public String customerEmail() { return customerEmail; }
    @Override public String customerPhone() { return customerPhone; }
    @Override public String shippingAddress() { return shippingAddress; }
    @Override public String paymentMethod() { return paymentMethod; }
    @Override public BigDecimal subtotal() { return subtotal; }
    @Override public BigDecimal shippingFee() { return shippingFee; }
    @Override public BigDecimal total() { return total; }
    @Override public String status() { return status; }
    @Override public List<? extends OrderItemIdentity> items() { return items; }
}
