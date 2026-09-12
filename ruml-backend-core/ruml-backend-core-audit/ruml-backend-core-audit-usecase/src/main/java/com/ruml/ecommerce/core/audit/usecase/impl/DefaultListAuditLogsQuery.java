package com.ruml.ecommerce.core.audit.usecase.impl;

import com.ruml.ecommerce.core.audit.factory.request.ListAuditLogsRequest;
import com.ruml.ecommerce.core.audit.factory.response.ListAuditLogsResponse;
import com.ruml.ecommerce.core.audit.port.AuditReadPort;
import com.ruml.ecommerce.core.audit.usecase.ListAuditLogsQuery;

public class DefaultListAuditLogsQuery implements ListAuditLogsQuery {

    private final AuditReadPort auditReadPort;

    public DefaultListAuditLogsQuery(AuditReadPort auditReadPort) {
        this.auditReadPort = auditReadPort;
    }

    @Override
    public ListAuditLogsResponse execute(ListAuditLogsRequest request) {
        return new ListAuditLogsResponse(auditReadPort.findAuditLogs(request.query()));
    }
}
