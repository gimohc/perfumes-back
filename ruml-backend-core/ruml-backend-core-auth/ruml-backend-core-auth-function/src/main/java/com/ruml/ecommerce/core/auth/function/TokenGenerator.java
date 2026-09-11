package com.ruml.ecommerce.core.auth.function;

public interface TokenGenerator {
    String generateToken(String userId);
}
