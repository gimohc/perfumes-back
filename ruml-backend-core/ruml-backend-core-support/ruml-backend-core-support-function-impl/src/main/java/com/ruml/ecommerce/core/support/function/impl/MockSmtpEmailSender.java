package com.ruml.ecommerce.core.support.function.impl;
import com.ruml.ecommerce.core.support.function.EmailSender;
import org.springframework.stereotype.Component;
@Component
public class MockSmtpEmailSender implements EmailSender {
    @Override
    public void sendEmail(String to, String subject, String body) {
        // TODO: Requires SMTP credentials
        System.out.println("Mock sending email to: " + to);
    }
}
