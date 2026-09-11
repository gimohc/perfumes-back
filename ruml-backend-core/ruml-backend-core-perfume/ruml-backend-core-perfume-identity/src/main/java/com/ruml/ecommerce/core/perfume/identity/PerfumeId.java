package com.ruml.ecommerce.core.perfume.identity;

import com.ruml.ecommerce.core.shared.identity.Identity;
import java.io.Serializable;

public record PerfumeId(String value) implements Identity<String>, Serializable {
}
