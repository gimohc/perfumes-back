package com.ruml.ecommerce.core.b2b.port;

import com.ruml.ecommerce.core.b2b.entity.readmodel.QuoteReadModel;
import com.ruml.ecommerce.core.shared.entity.pagination.PageQuery;
import com.ruml.ecommerce.core.shared.entity.pagination.PageResult;
import com.ruml.ecommerce.core.b2b.entity.B2BQuoteId;

import java.util.Optional;

public interface QuoteReadPort {
    PageResult<QuoteReadModel> findInvoices(PageQuery query);
    Optional<QuoteReadModel> findById(B2BQuoteId id);
}
