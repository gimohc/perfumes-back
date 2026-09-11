package com.ruml.ecommerce.core.auth.dao.jpa;

import com.ruml.ecommerce.core.auth.entity.AuthEntity;
import com.ruml.ecommerce.core.auth.identity.AuthId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, AuthId> {
}
