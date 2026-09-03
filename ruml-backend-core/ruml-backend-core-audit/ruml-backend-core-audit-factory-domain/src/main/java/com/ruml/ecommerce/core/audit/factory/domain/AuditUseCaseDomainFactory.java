package com.ruml.ecommerce.core.audit.factory.domain;
import com.ruml.ecommerce.core.audit.factory.domain.request.LogActionRequest;
public interface AuditUseCaseDomainFactory {
    void logAction(LogActionRequest request);
}
