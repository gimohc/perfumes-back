package com.ruml.ecommerce.core.auth.port;

import com.ruml.ecommerce.core.auth.entity.AuthEntity;
import com.ruml.ecommerce.core.auth.entity.AuthId;
import java.util.Optional;

public interface AuthPort {
    Optional<AuthEntity> findByEmail(String email);
    Optional<AuthEntity> findById(AuthId id);
}
