package com.ruml.ecommerce.presentation.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = "com.ruml.ecommerce")
public class RumlApplication {
    public static void main(String[] args) {
        SpringApplication.run(RumlApplication.class, args);
    }
}
