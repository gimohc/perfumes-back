package com.ruml.ecommerce.presentation.controller.perfume;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Tag(name = "Perfume", description = "Perfume management API")
@RequestMapping("/api/perfumes")
public class PerfumeController {
}
