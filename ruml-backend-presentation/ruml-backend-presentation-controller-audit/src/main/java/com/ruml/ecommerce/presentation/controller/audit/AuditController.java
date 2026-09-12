package com.ruml.ecommerce.presentation.controller.audit;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Tag(name = "Audit", description = "Audit management API")
@RequestMapping("/api/audits")
public class AuditController {
}
