package com.ruml.ecommerce.core.support.dao.jpa;

import com.ruml.ecommerce.core.support.dao.SupportDao;
import com.ruml.ecommerce.core.support.entity.SupportEntity;
import com.ruml.ecommerce.core.support.identity.SupportId;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class JpaSupportDao implements SupportDao {
    private final SupportRepository repository;

    public JpaSupportDao(SupportRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<SupportEntity> findById(SupportId id) {
        return repository.findById(id);
    }
}
