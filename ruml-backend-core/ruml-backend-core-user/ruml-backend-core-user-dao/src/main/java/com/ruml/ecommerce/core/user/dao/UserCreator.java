package com.ruml.ecommerce.core.user.dao;
import com.ruml.ecommerce.core.shared.dao.Creator;
import com.ruml.ecommerce.core.user.identity.UserIdentity;
public interface UserCreator extends Creator<UserIdentity> {
    UserCreator email(String email);
    UserCreator passwordHash(String passwordHash);
    UserCreator role(String role);
}
