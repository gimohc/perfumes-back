package com.ruml.ecommerce.core.perfume.usecase;

import com.ruml.ecommerce.core.perfume.entity.readmodel.PerfumeReadModel;
import com.ruml.ecommerce.core.perfume.factory.request.ListPerfumesRequest;
import com.ruml.ecommerce.core.perfume.factory.response.ListPerfumesResponse;
import com.ruml.ecommerce.core.perfume.port.PerfumeReadPort;
import com.ruml.ecommerce.core.shared.entity.pagination.PageResult;

public class DefaultListPerfumesQuery implements ListPerfumesQuery {

    private final PerfumeReadPort readPort;

    public DefaultListPerfumesQuery(PerfumeReadPort readPort) {
        this.readPort = readPort;
    }

    @Override
    public ListPerfumesResponse execute(ListPerfumesRequest input) {
        PageResult<PerfumeReadModel> page = readPort.findPerfumes(input.query());
        return new ListPerfumesResponse(page);
    }
}
