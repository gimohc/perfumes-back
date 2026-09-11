package com.ruml.ecommerce.core.perfume.dao.jpa;

import com.ruml.ecommerce.core.perfume.dao.PerfumeDao;
import com.ruml.ecommerce.core.perfume.entity.PerfumeEntity;
import com.ruml.ecommerce.core.perfume.identity.PerfumeId;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class JpaPerfumeDao implements PerfumeDao {
    private final PerfumeRepository repository;

    public JpaPerfumeDao(PerfumeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<PerfumeEntity> findById(PerfumeId id) {
        return repository.findById(id);
    }
}
