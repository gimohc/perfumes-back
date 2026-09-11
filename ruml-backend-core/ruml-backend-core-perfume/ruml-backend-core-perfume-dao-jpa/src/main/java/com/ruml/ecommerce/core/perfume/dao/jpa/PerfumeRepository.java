package com.ruml.ecommerce.core.perfume.dao.jpa;

import com.ruml.ecommerce.core.perfume.entity.PerfumeEntity;
import com.ruml.ecommerce.core.perfume.identity.PerfumeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfumeRepository extends JpaRepository<PerfumeEntity, PerfumeId> {
}
