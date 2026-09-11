package com.ruml.ecommerce.core.perfume.usecase.impl;

import com.ruml.ecommerce.core.perfume.factory.request.GetPerfumesRequest;
import com.ruml.ecommerce.core.perfume.factory.response.GetPerfumesResponse;
import com.ruml.ecommerce.core.perfume.factory.response.PerfumeReadModel;
import com.ruml.ecommerce.core.perfume.usecase.GetPerfumesUseCase;
import com.ruml.ecommerce.core.perfume.usecase.port.PerfumeQueryPort;
import java.util.List;

public class DefaultGetPerfumesUseCase implements GetPerfumesUseCase {

    private final PerfumeQueryPort queryPort;

    public DefaultGetPerfumesUseCase(PerfumeQueryPort queryPort) {
        this.queryPort = queryPort;
    }

    @Override
    public GetPerfumesResponse execute(GetPerfumesRequest request) {
        List<PerfumeReadModel> perfumes = queryPort.findAll();
        return new GetPerfumesResponse(perfumes);
    }
}
