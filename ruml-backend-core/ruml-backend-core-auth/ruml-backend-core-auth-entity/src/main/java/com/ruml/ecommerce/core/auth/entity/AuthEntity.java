package com.ruml.ecommerce.core.auth.entity;

import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.auth.identity.AuthId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "auths")
public class AuthEntity implements Entity<AuthId> {
    
    @EmbeddedId
    private AuthId id;

    protected AuthEntity() {
        // JPA requires default constructor
    }

    public AuthEntity(AuthId id) {
        this.id = id;
    }

    @Override
    public AuthId getId() {
        return id;
    }
}
