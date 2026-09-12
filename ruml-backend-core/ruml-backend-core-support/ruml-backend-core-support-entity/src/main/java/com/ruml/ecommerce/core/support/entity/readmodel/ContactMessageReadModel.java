package com.ruml.ecommerce.core.support.entity.readmodel;

public record ContactMessageReadModel(
    String id,
    String senderEmail,
    String subject,
    String messageBody,
    boolean replied
) {}
