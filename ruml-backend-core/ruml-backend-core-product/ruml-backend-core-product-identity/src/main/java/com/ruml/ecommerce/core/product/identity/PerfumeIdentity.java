package com.ruml.ecommerce.core.product.identity;
import com.ruml.ecommerce.core.shared.identity.Identity;
import java.math.BigDecimal;
public interface PerfumeIdentity extends Identity {
    String nameEn(); String nameAr();
    String descriptionEn(); String descriptionAr();
    BigDecimal price(); String image(); String category();
}
