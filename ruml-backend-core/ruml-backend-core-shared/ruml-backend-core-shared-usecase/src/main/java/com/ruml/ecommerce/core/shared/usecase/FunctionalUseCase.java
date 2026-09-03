package com.ruml.ecommerce.core.shared.usecase;
import jakarta.validation.Validator;
public abstract class FunctionalUseCase<REQ, RES> {
    protected final Validator validator;
    protected FunctionalUseCase(Validator validator) { this.validator = validator; }
    public RES execute(REQ request) { return doExecute(request); }
    protected abstract RES doExecute(REQ request);
}
