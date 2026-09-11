package com.ruml.ecommerce.core.auth.function.impl;

import com.ruml.ecommerce.core.auth.function.TokenGenerator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenGenerator implements TokenGenerator {
    
    // For production, this should be injected from environment variables
    public static final String SECRET = "ruM1-SceNtS-sup3r-s3cr3t-k3y-f0r-jwt-gen3rat10n-1234567890";
    public static final Key SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());
    private static final long EXPIRATION_TIME = 86400000; // 1 day

    @Override
    public String generateToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }
}
