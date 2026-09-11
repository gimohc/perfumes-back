package com.ruml.ecommerce.core.perfume.entity;

import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.perfume.identity.PerfumeId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Table;

import com.ruml.ecommerce.core.perfume.entity.value.BottleVolume;
import com.ruml.ecommerce.core.perfume.entity.value.Concentration;
import com.ruml.ecommerce.core.perfume.entity.value.ScentProfile;
import com.ruml.ecommerce.core.shared.exception.DomainException;
import java.math.BigDecimal;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@jakarta.persistence.Entity
@Table(name = "perfumes")
public class PerfumeEntity implements Entity<PerfumeId> {
    
    @EmbeddedId
    private PerfumeId id;

    private String name;
    private BigDecimal price;
    
    @Embedded
    private ScentProfile scentProfile;
    
    @Embedded
    private BottleVolume volume;
    
    @Enumerated(EnumType.STRING)
    private Concentration concentration;

    private int stockQuantity;

    protected PerfumeEntity() {
        // JPA requires default constructor
    }

    public PerfumeEntity(PerfumeId id, String name, BigDecimal price, ScentProfile scentProfile, BottleVolume volume, Concentration concentration, int initialStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.scentProfile = scentProfile;
        this.volume = volume;
        this.concentration = concentration;
        this.stockQuantity = initialStock;
    }

    @Override
    public PerfumeId getId() {
        return id;
    }

    public void allocateStock(int quantity) {
        if (quantity <= 0) {
            throw new DomainException("INVALID_ALLOCATION", "Quantity must be positive");
        }
        if (this.stockQuantity < quantity) {
            throw new DomainException("OUT_OF_STOCK", "Not enough stock to allocate " + quantity + " units");
        }
        this.stockQuantity -= quantity;
    }

    public void restock(int quantity) {
        if (quantity <= 0) {
            throw new DomainException("INVALID_RESTOCK", "Quantity must be positive");
        }
        this.stockQuantity += quantity;
    }

    // Getters for internal/repository use
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
}
