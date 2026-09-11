package com.ruml.ecommerce.core.audit.usecase;

import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;
import com.ruml.ecommerce.core.audit.factory.request.LogAuditActionRequest;
import com.ruml.ecommerce.core.audit.factory.response.LogAuditActionResponse;

public interface LogAuditActionUseCase extends FunctionalUseCase<LogAuditActionRequest, LogAuditActionResponse> {
}
