package com.ruml.ecommerce.presentation.controller.store;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Tag(name = "Store", description = "Store management API")
@RequestMapping("/api/stores")
public class StoreController {
}
