package com.ruml.ecommerce.presentation.controller.auth;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Tag(name = "Auth", description = "Auth management API")
@RequestMapping("/api/auths")
public class AuthController {
}
