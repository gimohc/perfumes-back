package com.ruml.ecommerce.core.auth.usecase;

import com.ruml.ecommerce.core.auth.entity.AuthEntity;
import com.ruml.ecommerce.core.auth.factory.request.LoginRequest;
import com.ruml.ecommerce.core.auth.factory.response.LoginResponse;
import com.ruml.ecommerce.core.auth.function.PasswordHasher;
import com.ruml.ecommerce.core.auth.function.TokenGenerator;
import com.ruml.ecommerce.core.auth.port.AuthPort;
import com.ruml.ecommerce.core.shared.exception.DomainException;

public class DefaultLoginUseCase implements LoginUseCase {

    private final AuthPort authPort;
    private final PasswordHasher passwordHasher;
    private final TokenGenerator tokenGenerator;

    public DefaultLoginUseCase(AuthPort authPort, PasswordHasher passwordHasher, TokenGenerator tokenGenerator) {
        this.authPort = authPort;
        this.passwordHasher = passwordHasher;
        this.tokenGenerator = tokenGenerator;
    }

    @Override
    public LoginResponse execute(LoginRequest input) {
        AuthEntity auth = authPort.findByEmail(input.email())
                .orElseThrow(() -> new DomainException("INVALID_CREDENTIALS", "Invalid email or password"));

        if (!passwordHasher.matches(input.password(), auth.getPasswordHash())) {
            throw new DomainException("INVALID_CREDENTIALS", "Invalid email or password");
        }

        String token = tokenGenerator.generateToken(auth.getId().value());
        return new LoginResponse(token);
    }
}
