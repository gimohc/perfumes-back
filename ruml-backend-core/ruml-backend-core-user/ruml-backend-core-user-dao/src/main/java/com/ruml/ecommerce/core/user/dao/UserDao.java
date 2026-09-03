package com.ruml.ecommerce.core.user.dao;
import com.ruml.ecommerce.core.shared.dao.Dao;
import com.ruml.ecommerce.core.user.identity.UserIdentity;
import java.util.Optional;
public interface UserDao extends Dao<UserIdentity, UserCreator, UserUpdater> {
    Optional<UserIdentity> findByEmail(String email);
}
