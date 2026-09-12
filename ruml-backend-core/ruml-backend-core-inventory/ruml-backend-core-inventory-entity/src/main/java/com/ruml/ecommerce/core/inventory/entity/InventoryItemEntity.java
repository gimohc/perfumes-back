package com.ruml.ecommerce.core.inventory.entity;

import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.shared.exception.DomainException;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "inventory_items")
public class InventoryItemEntity implements Entity<InventoryItemId> {

    @EmbeddedId
    private InventoryItemId id;

    private String perfumeId;

    private int totalStock;
    private int reservedStock;

    protected InventoryItemEntity() {}

    public InventoryItemEntity(InventoryItemId id, String perfumeId, StockQuantity initialStock) {
        this.id = id;
        this.perfumeId = perfumeId;
        this.totalStock = initialStock.amount();
        this.reservedStock = 0;
    }

    @Override
    public InventoryItemId getId() {
        return id;
    }

    public void reserve(int quantity) {
        if (quantity <= 0) {
            throw new DomainException("INVALID_QUANTITY", "Reservation quantity must be strictly positive");
        }
        if ((totalStock - reservedStock) < quantity) {
            throw new DomainException("OUT_OF_STOCK", "Not enough stock available to reserve");
        }
        this.reservedStock += quantity;
    }

    public void releaseReservation(int quantity) {
        if (quantity <= 0) {
            throw new DomainException("INVALID_QUANTITY", "Release quantity must be strictly positive");
        }
        if (this.reservedStock < quantity) {
            throw new DomainException("INVALID_RELEASE", "Cannot release more stock than is reserved");
        }
        this.reservedStock -= quantity;
    }

    public void deduct(int quantity) {
        if (quantity <= 0) {
            throw new DomainException("INVALID_QUANTITY", "Deduction quantity must be strictly positive");
        }
        if (this.reservedStock < quantity) {
            throw new DomainException("INVALID_DEDUCTION", "Cannot deduct unreserved stock. Must reserve first.");
        }
        this.totalStock -= quantity;
        this.reservedStock -= quantity;
    }

    // Getters
    public String getPerfumeId() { return perfumeId; }
    public int getTotalStock() { return totalStock; }
    public int getReservedStock() { return reservedStock; }
    public int getAvailableStock() { return totalStock - reservedStock; }
}
