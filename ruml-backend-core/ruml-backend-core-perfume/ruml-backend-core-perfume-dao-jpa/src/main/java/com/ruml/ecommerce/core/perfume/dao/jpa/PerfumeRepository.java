package com.ruml.ecommerce.core.perfume.dao.jpa;

import com.ruml.ecommerce.core.perfume.entity.PerfumeEntity;
import com.ruml.ecommerce.core.perfume.identity.PerfumeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruml.ecommerce.core.perfume.factory.response.PerfumeReadModel;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface PerfumeRepository extends JpaRepository<PerfumeEntity, PerfumeId> {
    
    @Query("SELECT new com.ruml.ecommerce.core.perfume.factory.response.PerfumeReadModel(" +
           "p.id.value, p.name, p.price, p.scentProfile.topNotes, p.scentProfile.heartNotes, p.scentProfile.baseNotes, " +
           "CASE WHEN p.stockQuantity > 0 THEN true ELSE false END) " +
           "FROM PerfumeEntity p")
    List<PerfumeReadModel> findAllReadModels();
}
