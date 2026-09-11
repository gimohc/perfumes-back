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

    protected StoreEntity() {
        // JPA requires default constructor
    }

    public StoreEntity(StoreId id) {
        this.id = id;
    }

    @Override
    public StoreId getId() {
        return id;
    }
}
