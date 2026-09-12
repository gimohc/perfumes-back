package com.ruml.ecommerce.presentation.controller.support;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Tag(name = "Support", description = "Support management API")
@RequestMapping("/api/supports")
public class SupportController {
}
