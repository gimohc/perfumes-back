package com.ruml.ecommerce.core.support.function.impl;

import com.ruml.ecommerce.core.support.function.EmailSender;

public class MockSmtpEmailSender implements EmailSender {
    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println("Mock sending email to: " + to);
    }
}
