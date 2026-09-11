package com.ruml.ecommerce.core.auth.dao;

import com.ruml.ecommerce.core.shared.dao.Dao;
import com.ruml.ecommerce.core.auth.entity.AuthEntity;
import com.ruml.ecommerce.core.auth.identity.AuthId;

public interface AuthDao extends Dao<AuthEntity, AuthId> {
}
