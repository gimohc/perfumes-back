package com.ruml.ecommerce.core.auth.usecase;

import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;
import com.ruml.ecommerce.core.auth.factory.request.GetSessionRequest;
import com.ruml.ecommerce.core.auth.factory.response.GetSessionResponse;

public interface GetSessionUseCase extends FunctionalUseCase<GetSessionRequest, GetSessionResponse> {
}
