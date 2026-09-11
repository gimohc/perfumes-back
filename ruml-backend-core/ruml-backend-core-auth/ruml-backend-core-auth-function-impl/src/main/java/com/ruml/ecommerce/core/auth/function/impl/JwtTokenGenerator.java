package com.ruml.ecommerce.core.auth.function.impl;

import com.ruml.ecommerce.core.auth.function.TokenGenerator;

public class JwtTokenGenerator implements TokenGenerator {
    @Override
    public String generateToken(String userId) {
        return "jwt-token-for-" + userId;
    }
}
