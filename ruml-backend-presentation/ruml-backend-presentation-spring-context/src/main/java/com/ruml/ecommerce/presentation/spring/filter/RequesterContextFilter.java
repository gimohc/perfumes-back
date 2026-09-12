package com.ruml.ecommerce.presentation.spring.filter;

import com.ruml.ecommerce.core.shared.usecase.context.RequesterContext;
import com.ruml.ecommerce.core.shared.usecase.context.RequesterContextHolder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.LocaleResolver;

import java.io.IOException;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public class RequesterContextFilter extends OncePerRequestFilter {

    private final LocaleResolver localeResolver;

    public RequesterContextFilter(LocaleResolver localeResolver) {
        this.localeResolver = localeResolver;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        try {
            Locale locale = localeResolver.resolveLocale(request);
            String userId = null;
            Set<String> roles = Collections.emptySet();

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")) {
                userId = authentication.getName();
                roles = authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toSet());
            }

            RequesterContext context = new RequesterContext(userId, roles, locale);
            RequesterContextHolder.setContext(context);

            filterChain.doFilter(request, response);
        } finally {
            RequesterContextHolder.clearContext();
        }
    }
}
