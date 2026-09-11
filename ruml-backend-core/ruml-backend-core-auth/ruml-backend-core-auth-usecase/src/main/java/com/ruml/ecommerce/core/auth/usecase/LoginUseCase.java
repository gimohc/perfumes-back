package com.ruml.ecommerce.core.auth.usecase;

import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;
import com.ruml.ecommerce.core.auth.factory.request.LoginRequest;
import com.ruml.ecommerce.core.auth.factory.response.LoginResponse;

public interface LoginUseCase extends FunctionalUseCase<LoginRequest, LoginResponse> {
}
