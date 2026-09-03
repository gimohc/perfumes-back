package com.ruml.ecommerce.core.support.identity;
import com.ruml.ecommerce.core.shared.identity.Identity;
public interface MessageIdentity extends Identity {
    String name(); String email(); String phone(); String message(); String status();
}
