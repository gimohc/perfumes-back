package com.ruml.ecommerce.core.audit.identity;

import com.ruml.ecommerce.core.shared.identity.Identity;
import java.io.Serializable;

public record AuditId(String value) implements Identity<String>, Serializable {
}
