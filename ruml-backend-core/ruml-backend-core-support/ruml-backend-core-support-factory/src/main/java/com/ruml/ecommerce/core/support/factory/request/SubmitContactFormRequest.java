package com.ruml.ecommerce.core.support.factory.request;

public record SubmitContactFormRequest(
    String senderEmail,
    String subject,
    String messageBody
) {}
