package com.ruml.ecommerce.core.store.identity;

import com.ruml.ecommerce.core.shared.identity.Identity;
import java.io.Serializable;

public record StoreId(String value) implements Identity<String>, Serializable {
}
