package com.ruml.ecommerce.presentation.controller.audit;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/admin/audit-logs")
public class AuditController {
    @GetMapping
    public Object getLogs() { return null; }
}
