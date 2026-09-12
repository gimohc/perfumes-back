package com.ruml.ecommerce.core.b2b.usecase;

import com.ruml.ecommerce.core.b2b.factory.request.ListInvoicesRequest;
import com.ruml.ecommerce.core.b2b.factory.response.ListInvoicesResponse;
import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;

public interface ListInvoicesQuery extends FunctionalUseCase<ListInvoicesRequest, ListInvoicesResponse> {
}
