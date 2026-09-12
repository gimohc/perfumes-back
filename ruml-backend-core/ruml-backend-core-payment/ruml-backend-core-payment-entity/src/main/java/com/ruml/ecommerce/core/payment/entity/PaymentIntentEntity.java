package com.ruml.ecommerce.core.payment.entity;

import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.shared.exception.DomainException;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@jakarta.persistence.Entity
@Table(name = "payment_intents")
public class PaymentIntentEntity implements Entity<PaymentIntentId> {

    @EmbeddedId
    private PaymentIntentId id;

    private String orderId;
    private BigDecimal amount;
    private String currency;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private String idempotencyKey;
    private String gatewayTransactionId;
    private String redirectUrl;

    protected PaymentIntentEntity() {}

    public PaymentIntentEntity(PaymentIntentId id, String orderId, BigDecimal amount, String currency, String idempotencyKey) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new DomainException("INVALID_AMOUNT", "Payment amount must be strictly positive");
        }
        
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.currency = currency;
        this.status = PaymentStatus.PENDING;
        this.idempotencyKey = idempotencyKey;
    }

    public void markAsSuccess(String transactionId) {
        if (this.status == PaymentStatus.SUCCESS) {
            // Idempotent success
            return;
        }
        if (this.status == PaymentStatus.FAILED) {
            throw new DomainException("INVALID_TRANSITION", "Cannot transition a failed payment to success");
        }
        this.status = PaymentStatus.SUCCESS;
        this.gatewayTransactionId = transactionId;
    }

    public void markAsFailed(String transactionId) {
        if (this.status == PaymentStatus.FAILED) {
            // Idempotent failure
            return;
        }
        if (this.status == PaymentStatus.SUCCESS) {
            throw new DomainException("INVALID_TRANSITION", "Cannot transition a successful payment to failed");
        }
        this.status = PaymentStatus.FAILED;
        this.gatewayTransactionId = transactionId;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public PaymentIntentId getId() {
        return id;
    }

    public String getOrderId() { return orderId; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public PaymentStatus getStatus() { return status; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public String getGatewayTransactionId() { return gatewayTransactionId; }
    public String getRedirectUrl() { return redirectUrl; }
}
