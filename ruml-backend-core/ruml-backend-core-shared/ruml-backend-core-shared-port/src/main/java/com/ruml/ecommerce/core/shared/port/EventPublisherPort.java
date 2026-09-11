package com.ruml.ecommerce.core.shared.port;

public interface EventPublisherPort {
    void publish(Object event);
}
