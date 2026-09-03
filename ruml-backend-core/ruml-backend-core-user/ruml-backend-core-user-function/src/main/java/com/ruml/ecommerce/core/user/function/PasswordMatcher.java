package com.ruml.ecommerce.core.user.function;
public interface PasswordMatcher {
    boolean matches(String rawPassword, String encodedPassword);
}
