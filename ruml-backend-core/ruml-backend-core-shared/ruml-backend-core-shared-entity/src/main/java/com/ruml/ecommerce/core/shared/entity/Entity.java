package com.ruml.ecommerce.core.shared.entity;
import com.ruml.ecommerce.core.shared.identity.Identity;
public abstract class Entity implements Identity {
    private String uuid;
    private java.time.Instant createdAt;
    @Override public String uuid() { return uuid; }
    @Override public java.time.Instant createdAt() { return createdAt; }
}
