package com.ruml.ecommerce.core.payment.port;

import com.ruml.ecommerce.core.payment.entity.PaymentIntentEntity;

public interface PaymentGatewayPort {
    String generatePaymentUrl(PaymentIntentEntity intent);
    boolean verifyWebhookSignature(String payload, String signature);
}
