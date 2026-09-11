package com.ruml.ecommerce.core.support.dao.jpa;

import com.ruml.ecommerce.core.support.entity.SupportEntity;
import com.ruml.ecommerce.core.support.identity.SupportId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<SupportEntity, SupportId> {
}
