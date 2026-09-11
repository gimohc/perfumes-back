package com.ruml.ecommerce.core.store.dao.jpa;

import com.ruml.ecommerce.core.store.entity.StoreEntity;
import com.ruml.ecommerce.core.store.identity.StoreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, StoreId> {
}
