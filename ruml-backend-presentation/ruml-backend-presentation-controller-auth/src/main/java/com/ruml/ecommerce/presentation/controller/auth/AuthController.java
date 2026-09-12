package com.ruml.ecommerce.presentation.controller.auth;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import com.ruml.ecommerce.core.auth.factory.request.GetSessionRequest;
import com.ruml.ecommerce.core.auth.factory.request.LoginRequest;
import com.ruml.ecommerce.core.auth.factory.response.GetSessionResponse;
import com.ruml.ecommerce.core.auth.factory.response.LoginResponse;
import com.ruml.ecommerce.core.auth.usecase.GetSessionUseCase;
import com.ruml.ecommerce.core.auth.usecase.LoginUseCase;
import com.ruml.ecommerce.core.shared.usecase.context.RequesterContext;
import com.ruml.ecommerce.core.shared.usecase.context.RequesterContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Tag(name = "Auth", description = "Auth management API")
@RequestMapping("/api/auths")
public class AuthController {

    private final LoginUseCase loginUseCase;
    private final GetSessionUseCase getSessionUseCase;

    public AuthController(LoginUseCase loginUseCase, GetSessionUseCase getSessionUseCase) {
        this.loginUseCase = loginUseCase;
        this.getSessionUseCase = getSessionUseCase;
    }

    @PostMapping("/login")
    @Operation(summary = "Login user")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = loginUseCase.execute(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/session")
    @Operation(summary = "Get current session details")
    public ResponseEntity<GetSessionResponse> getSession() {
        RequesterContext context = RequesterContextHolder.getContext();
        String userId = (context != null) ? context.userId() : null;
        
        GetSessionResponse response = getSessionUseCase.execute(new GetSessionRequest(userId));
        return ResponseEntity.ok(response);
    }
}
