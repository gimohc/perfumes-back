package com.ruml.ecommerce.core.audit.port;

import com.ruml.ecommerce.core.audit.entity.readmodel.AuditReadModel;
import com.ruml.ecommerce.core.shared.entity.pagination.PageQuery;
import com.ruml.ecommerce.core.shared.entity.pagination.PageResult;

public interface AuditReadPort {
    PageResult<AuditReadModel> findAuditLogs(PageQuery query);
}
