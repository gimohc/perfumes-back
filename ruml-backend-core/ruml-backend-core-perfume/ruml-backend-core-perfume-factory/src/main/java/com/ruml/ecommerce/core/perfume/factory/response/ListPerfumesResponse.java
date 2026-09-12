package com.ruml.ecommerce.core.perfume.factory.response;

import com.ruml.ecommerce.core.perfume.entity.readmodel.PerfumeReadModel;
import com.ruml.ecommerce.core.shared.entity.pagination.PageResult;

public record ListPerfumesResponse(PageResult<PerfumeReadModel> page) {}
