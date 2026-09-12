package com.ruml.ecommerce.core.payment.entity;

import com.ruml.ecommerce.core.shared.identity.Identity;
import java.io.Serializable;

public record PaymentIntentId(String value) implements Identity<String>, Serializable {}
