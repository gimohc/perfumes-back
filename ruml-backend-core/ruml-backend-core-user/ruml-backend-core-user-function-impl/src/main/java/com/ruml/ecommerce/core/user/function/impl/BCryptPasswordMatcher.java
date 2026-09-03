package com.ruml.ecommerce.core.user.function.impl;
import com.ruml.ecommerce.core.user.function.PasswordMatcher;
import org.springframework.stereotype.Component;
@Component
public class BCryptPasswordMatcher implements PasswordMatcher {
    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        // TODO: Requires BCrypt dependency to actually verify
        return rawPassword.equals(encodedPassword); // Mock implementation
    }
}
