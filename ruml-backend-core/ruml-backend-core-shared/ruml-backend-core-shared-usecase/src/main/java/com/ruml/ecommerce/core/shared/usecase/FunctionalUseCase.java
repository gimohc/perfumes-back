package com.ruml.ecommerce.core.shared.usecase;

public interface FunctionalUseCase<I, O> {
    O execute(I request);
}
