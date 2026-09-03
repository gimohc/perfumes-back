package com.ruml.ecommerce.core.shared.identity;
public interface Identity {
    String uuid();
    java.time.Instant createdAt();
}
