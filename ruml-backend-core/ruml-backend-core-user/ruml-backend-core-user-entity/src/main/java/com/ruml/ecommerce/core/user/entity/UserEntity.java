package com.ruml.ecommerce.core.user.entity;
import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.user.identity.UserIdentity;
public class UserEntity extends Entity implements UserIdentity {
    private String email;
    private String passwordHash;
    private String role;
    @Override public String email() { return email; }
    @Override public String passwordHash() { return passwordHash; }
    @Override public String role() { return role; }
}
