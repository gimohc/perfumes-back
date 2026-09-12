package com.ruml.ecommerce.core.audit.factory.response;

import com.ruml.ecommerce.core.audit.entity.readmodel.AuditReadModel;
import com.ruml.ecommerce.core.shared.entity.pagination.PageResult;

public record ListAuditLogsResponse(PageResult<AuditReadModel> page) {}
