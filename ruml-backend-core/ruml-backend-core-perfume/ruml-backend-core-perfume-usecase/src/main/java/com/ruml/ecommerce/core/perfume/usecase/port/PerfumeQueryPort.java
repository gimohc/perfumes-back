package com.ruml.ecommerce.core.perfume.usecase.port;

import com.ruml.ecommerce.core.perfume.factory.response.PerfumeReadModel;
import java.util.List;

public interface PerfumeQueryPort {
    List<PerfumeReadModel> findAll();
}
