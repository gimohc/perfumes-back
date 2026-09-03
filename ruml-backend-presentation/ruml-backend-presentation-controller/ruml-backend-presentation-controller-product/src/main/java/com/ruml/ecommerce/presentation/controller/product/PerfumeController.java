package com.ruml.ecommerce.presentation.controller.product;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class PerfumeController {
    @GetMapping("/perfumes")
    public Object listPerfumes() { return null; }
    @PostMapping("/admin/perfumes")
    public Object upsertPerfume(@RequestBody Object request) { return null; }
}
