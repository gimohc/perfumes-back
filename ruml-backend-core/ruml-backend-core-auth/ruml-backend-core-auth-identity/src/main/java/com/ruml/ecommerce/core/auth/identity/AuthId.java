package com.ruml.ecommerce.core.auth.identity;

import com.ruml.ecommerce.core.shared.identity.Identity;
import java.io.Serializable;

public record AuthId(String value) implements Identity<String>, Serializable {
}
