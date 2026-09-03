package com.ruml.ecommerce.core.order.function.impl;
import com.ruml.ecommerce.core.order.function.OrderIdGenerator;
import org.springframework.stereotype.Component;
import java.util.UUID;
@Component
public class RandomOrderIdGenerator implements OrderIdGenerator {
    @Override
    public String generate() {
        return "ALCH-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
    }
}
