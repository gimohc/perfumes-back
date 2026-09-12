package com.ruml.ecommerce.core.audit.usecase;

import com.ruml.ecommerce.core.audit.factory.request.ListAuditLogsRequest;
import com.ruml.ecommerce.core.audit.factory.response.ListAuditLogsResponse;
import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;

public interface ListAuditLogsQuery extends FunctionalUseCase<ListAuditLogsRequest, ListAuditLogsResponse> {
}
