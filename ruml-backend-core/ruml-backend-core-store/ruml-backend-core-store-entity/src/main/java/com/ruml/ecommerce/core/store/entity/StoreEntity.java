package com.ruml.ecommerce.core.store.entity;

import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.store.identity.StoreId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "stores")
public class StoreEntity implements Entity<StoreId> {
    
    @EmbeddedId
    private StoreId id;

    private String currency;
    private int minimumOrderQuantity;
    private java.math.BigDecimal freeShippingThreshold;
    private String contactEmail;
    private String contactPhone;

    protected StoreEntity() {
        // JPA requires default constructor
    }

    public StoreEntity(StoreId id, String currency, int minimumOrderQuantity, java.math.BigDecimal freeShippingThreshold, String contactEmail, String contactPhone) {
        this.id = id;
        this.currency = currency;
        this.minimumOrderQuantity = minimumOrderQuantity;
        this.freeShippingThreshold = freeShippingThreshold;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    @Override
    public StoreId getId() {
        return id;
    }

    public String getCurrency() { return currency; }
    public int getMinimumOrderQuantity() { return minimumOrderQuantity; }
    public java.math.BigDecimal getFreeShippingThreshold() { return freeShippingThreshold; }
    public String getContactEmail() { return contactEmail; }
    public String getContactPhone() { return contactPhone; }

    public void updateSettings(String currency, int minimumOrderQuantity, java.math.BigDecimal freeShippingThreshold, String contactEmail, String contactPhone) {
        this.currency = currency;
        this.minimumOrderQuantity = minimumOrderQuantity;
        this.freeShippingThreshold = freeShippingThreshold;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }
}
