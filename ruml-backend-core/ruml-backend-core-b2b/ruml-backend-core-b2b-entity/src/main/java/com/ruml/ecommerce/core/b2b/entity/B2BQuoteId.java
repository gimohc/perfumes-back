package com.ruml.ecommerce.core.b2b.entity;

import com.ruml.ecommerce.core.shared.identity.Identity;
import java.io.Serializable;

public record B2BQuoteId(String value) implements Identity<String>, Serializable {}
