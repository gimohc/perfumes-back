package com.ruml.ecommerce.core.auth.function;

public interface PasswordHasher {
    String hash(String rawPassword);
    boolean matches(String rawPassword, String encodedPassword);
}
