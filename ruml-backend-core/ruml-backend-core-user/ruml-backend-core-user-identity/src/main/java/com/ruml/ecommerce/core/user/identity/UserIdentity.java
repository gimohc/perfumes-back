package com.ruml.ecommerce.core.user.identity;
import com.ruml.ecommerce.core.shared.identity.Identity;
public interface UserIdentity extends Identity {
    String email();
    String passwordHash();
    String role();
}
