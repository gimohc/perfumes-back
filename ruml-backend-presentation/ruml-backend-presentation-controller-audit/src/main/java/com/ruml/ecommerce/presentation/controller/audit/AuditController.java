package com.ruml.ecommerce.presentation.controller.audit;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import com.ruml.ecommerce.core.audit.factory.request.ListAuditLogsRequest;
import com.ruml.ecommerce.core.audit.factory.response.ListAuditLogsResponse;
import com.ruml.ecommerce.core.audit.usecase.ListAuditLogsQuery;
import com.ruml.ecommerce.core.shared.entity.pagination.PageQuery;

@RestController
@Tag(name = "Audit", description = "Audit Logs API")
@RequestMapping("/api/admin")
public class AuditController {

    private final ListAuditLogsQuery listAuditLogsQuery;

    public AuditController(ListAuditLogsQuery listAuditLogsQuery) {
        this.listAuditLogsQuery = listAuditLogsQuery;
    }

    @GetMapping("/audit-logs")
    @Operation(summary = "List audit logs")
    public ResponseEntity<ListAuditLogsResponse> getAuditLogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "timestamp") String sortBy,
            @RequestParam(defaultValue = "DESC") String sortDirection) {
        
        PageQuery query = new PageQuery(page, size, sortBy, sortDirection);
        ListAuditLogsResponse response = listAuditLogsQuery.execute(new ListAuditLogsRequest(query));
        return ResponseEntity.ok(response);
    }
}
