package com.ruml.ecommerce.core.payment.port;

import com.ruml.ecommerce.core.payment.entity.PaymentIntentEntity;
import com.ruml.ecommerce.core.payment.entity.PaymentIntentId;
import java.util.Optional;

public interface PaymentIntentPort {
    PaymentIntentEntity save(PaymentIntentEntity entity);
    Optional<PaymentIntentEntity> findById(PaymentIntentId id);
    Optional<PaymentIntentEntity> findByIdempotencyKey(String idempotencyKey);
}
