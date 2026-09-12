package com.ruml.ecommerce.core.auth.usecase;

import com.ruml.ecommerce.core.auth.entity.AuthEntity;
import com.ruml.ecommerce.core.auth.entity.AuthId;
import com.ruml.ecommerce.core.auth.factory.request.GetSessionRequest;
import com.ruml.ecommerce.core.auth.factory.response.GetSessionResponse;
import com.ruml.ecommerce.core.auth.port.AuthPort;
import com.ruml.ecommerce.core.shared.exception.DomainException;

public class DefaultGetSessionUseCase implements GetSessionUseCase {

    private final AuthPort authPort;

    public DefaultGetSessionUseCase(AuthPort authPort) {
        this.authPort = authPort;
    }

    @Override
    public GetSessionResponse execute(GetSessionRequest input) {
        if (input.userId() == null) {
            throw new DomainException("UNAUTHORIZED", "User is not authenticated");
        }

        AuthEntity auth = authPort.findById(new AuthId(input.userId()))
                .orElseThrow(() -> new DomainException("USER_NOT_FOUND", "User not found"));

        return new GetSessionResponse(auth.getId().value(), auth.getEmail());
    }
}
