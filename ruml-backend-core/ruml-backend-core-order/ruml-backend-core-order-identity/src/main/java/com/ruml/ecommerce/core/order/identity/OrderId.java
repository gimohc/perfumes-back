package com.ruml.ecommerce.core.order.identity;

import com.ruml.ecommerce.core.shared.identity.Identity;
import java.io.Serializable;

public record OrderId(String value) implements Identity<String>, Serializable {
}
