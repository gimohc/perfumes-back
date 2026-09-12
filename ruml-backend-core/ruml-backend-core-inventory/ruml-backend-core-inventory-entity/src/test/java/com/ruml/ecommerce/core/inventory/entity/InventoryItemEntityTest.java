package com.ruml.ecommerce.core.inventory.entity;

import com.ruml.ecommerce.core.shared.exception.DomainException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class InventoryItemEntityTest {

    @Test
    void shouldInitializeWithZeroReservedStock() {
        InventoryItemEntity item = createItem(100);
        assertEquals(100, item.getTotalStock());
        assertEquals(0, item.getReservedStock());
        assertEquals(100, item.getAvailableStock());
    }

    @Test
    void shouldReserveSuccessfullyWhenSufficientStock() {
        InventoryItemEntity item = createItem(100);
        
        item.reserve(20);
        
        assertEquals(100, item.getTotalStock());
        assertEquals(20, item.getReservedStock());
        assertEquals(80, item.getAvailableStock());
    }

    @Test
    void shouldThrowExceptionWhenReservingMoreThanAvailable() {
        InventoryItemEntity item = createItem(50);
        
        DomainException ex = assertThrows(DomainException.class, () -> item.reserve(60));
        assertEquals("OUT_OF_STOCK", ex.getCode());
    }

    @Test
    void shouldReleaseReservationSuccessfully() {
        InventoryItemEntity item = createItem(100);
        item.reserve(30);
        
        item.releaseReservation(10);
        
        assertEquals(100, item.getTotalStock());
        assertEquals(20, item.getReservedStock());
        assertEquals(80, item.getAvailableStock());
    }

    @Test
    void shouldThrowExceptionWhenReleasingMoreThanReserved() {
        InventoryItemEntity item = createItem(100);
        item.reserve(10);
        
        DomainException ex = assertThrows(DomainException.class, () -> item.releaseReservation(20));
        assertEquals("INVALID_RELEASE", ex.getCode());
    }

    @Test
    void shouldDeductSuccessfullyWhenReserved() {
        InventoryItemEntity item = createItem(100);
        item.reserve(40);
        
        item.deduct(40);
        
        assertEquals(60, item.getTotalStock());
        assertEquals(0, item.getReservedStock());
        assertEquals(60, item.getAvailableStock());
    }

    @Test
    void shouldThrowExceptionWhenDeductingWithoutReservation() {
        InventoryItemEntity item = createItem(100);
        
        DomainException ex = assertThrows(DomainException.class, () -> item.deduct(20));
        assertEquals("INVALID_DEDUCTION", ex.getCode());
    }

    private InventoryItemEntity createItem(int initialStock) {
        return new InventoryItemEntity(
            new InventoryItemId(UUID.randomUUID().toString()),
            UUID.randomUUID().toString(),
            new StockQuantity(initialStock)
        );
    }
}
