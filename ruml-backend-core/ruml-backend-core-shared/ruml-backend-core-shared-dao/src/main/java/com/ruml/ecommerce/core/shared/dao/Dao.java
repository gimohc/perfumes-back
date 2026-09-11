package com.ruml.ecommerce.core.shared.dao;

import java.util.Optional;

public interface Dao<T, ID> {
    Optional<T> findById(ID id);
}
