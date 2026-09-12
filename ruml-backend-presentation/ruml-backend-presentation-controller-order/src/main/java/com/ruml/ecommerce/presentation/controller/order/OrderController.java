package com.ruml.ecommerce.presentation.controller.order;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Tag(name = "Order", description = "Order management API")
@RequestMapping("/api/orders")
public class OrderController {
}
