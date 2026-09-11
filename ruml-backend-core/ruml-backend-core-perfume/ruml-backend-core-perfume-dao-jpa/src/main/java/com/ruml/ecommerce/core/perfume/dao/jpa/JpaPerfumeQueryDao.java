package com.ruml.ecommerce.core.perfume.dao.jpa;

import com.ruml.ecommerce.core.perfume.factory.response.PerfumeReadModel;
import com.ruml.ecommerce.core.perfume.usecase.port.PerfumeQueryPort;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class JpaPerfumeQueryDao implements PerfumeQueryPort {

    private final PerfumeRepository repository;

    public JpaPerfumeQueryDao(PerfumeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PerfumeReadModel> findAll() {
        return repository.findAllReadModels();
    }
}
