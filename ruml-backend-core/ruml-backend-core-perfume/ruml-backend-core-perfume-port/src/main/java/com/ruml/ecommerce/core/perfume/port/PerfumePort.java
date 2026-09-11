package com.ruml.ecommerce.core.perfume.port;

import com.ruml.ecommerce.core.perfume.entity.PerfumeEntity;
import com.ruml.ecommerce.core.perfume.identity.PerfumeId;
import java.util.Optional;

public interface PerfumePort {
    PerfumeEntity save(PerfumeEntity perfume);
    Optional<PerfumeEntity> findById(PerfumeId id);
}
