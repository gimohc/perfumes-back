package com.ruml.ecommerce.core.auth.usecase;

import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;
import com.ruml.ecommerce.core.auth.factory.request.LogoutRequest;
import com.ruml.ecommerce.core.auth.factory.response.LogoutResponse;

public interface LogoutUseCase extends FunctionalUseCase<LogoutRequest, LogoutResponse> {
}
