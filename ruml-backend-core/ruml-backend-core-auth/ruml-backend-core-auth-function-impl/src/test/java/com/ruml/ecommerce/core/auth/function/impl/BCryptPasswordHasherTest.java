package com.ruml.ecommerce.core.auth.function.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BCryptPasswordHasherTest {

    private final BCryptPasswordHasher hasher = new BCryptPasswordHasher();

    @Test
    void testHashAndMatches() {
        String rawPassword = "mySecurePassword123";
        String encoded = hasher.hash(rawPassword);

        assertNotEquals(rawPassword, encoded);
        assertTrue(hasher.matches(rawPassword, encoded));
        assertFalse(hasher.matches("wrongPassword", encoded));
    }
}
