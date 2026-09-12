package com.ruml.ecommerce.core.shared.usecase.context;

import java.util.Locale;
import java.util.Set;

public record RequesterContext(String userId, Set<String> roles, Locale locale) {}
