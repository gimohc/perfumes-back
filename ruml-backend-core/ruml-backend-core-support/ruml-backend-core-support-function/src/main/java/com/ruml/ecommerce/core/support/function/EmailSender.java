package com.ruml.ecommerce.core.support.function;
public interface EmailSender {
    void sendEmail(String to, String subject, String body);
}
