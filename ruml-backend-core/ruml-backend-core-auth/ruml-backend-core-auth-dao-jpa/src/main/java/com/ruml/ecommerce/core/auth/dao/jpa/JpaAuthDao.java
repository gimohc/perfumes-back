package com.ruml.ecommerce.core.auth.dao.jpa;

import com.ruml.ecommerce.core.auth.dao.AuthDao;
import com.ruml.ecommerce.core.auth.entity.AuthEntity;
import com.ruml.ecommerce.core.auth.identity.AuthId;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class JpaAuthDao implements AuthDao {
    private final AuthRepository repository;

    public JpaAuthDao(AuthRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<AuthEntity> findById(AuthId id) {
        return repository.findById(id);
    }
}
