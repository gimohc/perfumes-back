package com.ruml.ecommerce.core.shared.usecase;

public interface ConsumerUseCase<I> {
    void execute(I request);
}
