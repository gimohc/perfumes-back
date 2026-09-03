package com.ruml.ecommerce.core.user.dao;
import com.ruml.ecommerce.core.shared.dao.Updater;
import com.ruml.ecommerce.core.user.identity.UserIdentity;
public interface UserUpdater extends Updater<UserIdentity> {
    UserUpdater passwordHash(String passwordHash);
    UserUpdater role(String role);
}
