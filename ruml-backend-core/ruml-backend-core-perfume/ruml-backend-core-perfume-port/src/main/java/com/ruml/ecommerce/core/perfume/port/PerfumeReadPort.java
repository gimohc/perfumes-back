package com.ruml.ecommerce.core.perfume.port;

import com.ruml.ecommerce.core.perfume.entity.readmodel.PerfumeReadModel;
import com.ruml.ecommerce.core.shared.entity.pagination.PageQuery;
import com.ruml.ecommerce.core.shared.entity.pagination.PageResult;
import com.ruml.ecommerce.core.perfume.identity.PerfumeId;
import java.util.Optional;

public interface PerfumeReadPort {
    PageResult<PerfumeReadModel> findPerfumes(PageQuery query);
    Optional<PerfumeReadModel> findById(PerfumeId id);
}
