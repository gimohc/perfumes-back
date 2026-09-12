package com.ruml.ecommerce.core.b2b.factory.response;

import com.ruml.ecommerce.core.b2b.entity.readmodel.QuoteReadModel;
import com.ruml.ecommerce.core.shared.entity.pagination.PageResult;

public record ListInvoicesResponse(PageResult<QuoteReadModel> page) {}
