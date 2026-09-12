package com.ruml.ecommerce.core.perfume.usecase;

import com.ruml.ecommerce.core.perfume.entity.readmodel.PerfumeReadModel;
import com.ruml.ecommerce.core.perfume.factory.request.GetPerfumeDetailsRequest;
import com.ruml.ecommerce.core.perfume.factory.response.GetPerfumeDetailsResponse;
import com.ruml.ecommerce.core.perfume.identity.PerfumeId;
import com.ruml.ecommerce.core.perfume.port.PerfumeReadPort;
import com.ruml.ecommerce.core.shared.exception.DomainException;

public class DefaultGetPerfumeDetailsQuery implements GetPerfumeDetailsQuery {

    private final PerfumeReadPort readPort;

    public DefaultGetPerfumeDetailsQuery(PerfumeReadPort readPort) {
        this.readPort = readPort;
    }

    @Override
    public GetPerfumeDetailsResponse execute(GetPerfumeDetailsRequest input) {
        PerfumeReadModel perfume = readPort.findById(new PerfumeId(input.perfumeId()))
                .orElseThrow(() -> new DomainException("PERFUME_NOT_FOUND", "Perfume not found"));
        return new GetPerfumeDetailsResponse(perfume);
    }
}
