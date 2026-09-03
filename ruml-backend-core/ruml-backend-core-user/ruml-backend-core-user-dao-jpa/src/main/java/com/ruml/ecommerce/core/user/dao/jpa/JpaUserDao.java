package com.ruml.ecommerce.core.user.dao.jpa;
import com.ruml.ecommerce.core.user.dao.UserDao;
import com.ruml.ecommerce.core.user.dao.UserCreator;
import com.ruml.ecommerce.core.user.dao.UserUpdater;
import com.ruml.ecommerce.core.user.identity.UserIdentity;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public class JpaUserDao implements UserDao {
    private final UserRepository repository;
    public JpaUserDao(UserRepository repository) { this.repository = repository; }
    @Override
    public Optional<UserIdentity> findByEmail(String email) {
        return repository.findByEmail(email).map(e -> (UserIdentity) e);
    }
    @Override
    public UserCreator creator() {
        return null; // Implementation omitted for brevity
    }
    @Override
    public UserUpdater updater(UserIdentity identity) {
        return null; // Implementation omitted for brevity
    }
}
