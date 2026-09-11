package com.ruml.ecommerce.core.support.identity;

import com.ruml.ecommerce.core.shared.identity.Identity;
import java.io.Serializable;

public record SupportId(String value) implements Identity<String>, Serializable {
}
