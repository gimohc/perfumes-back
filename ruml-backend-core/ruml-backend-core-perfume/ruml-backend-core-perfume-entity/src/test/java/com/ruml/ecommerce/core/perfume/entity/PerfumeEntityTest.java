package com.ruml.ecommerce.core.perfume.entity;

import com.ruml.ecommerce.core.perfume.entity.value.BottleVolume;
import com.ruml.ecommerce.core.perfume.entity.value.Concentration;
import com.ruml.ecommerce.core.perfume.entity.value.ScentProfile;
import com.ruml.ecommerce.core.perfume.identity.PerfumeId;
import com.ruml.ecommerce.core.shared.exception.DomainException;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PerfumeEntityTest {

    @Test
    void shouldAllocateStockSuccessfully() {
        PerfumeEntity perfume = createTestPerfume(10);
        perfume.allocateStock(3);
        assertEquals(7, perfume.getStockQuantity());
    }

    @Test
    void shouldThrowExceptionWhenAllocatingMoreThanInStock() {
        PerfumeEntity perfume = createTestPerfume(5);
        DomainException ex = assertThrows(DomainException.class, () -> perfume.allocateStock(10));
        assertEquals("OUT_OF_STOCK", ex.getCode());
    }

    @Test
    void shouldRestockSuccessfully() {
        PerfumeEntity perfume = createTestPerfume(5);
        perfume.restock(5);
        assertEquals(10, perfume.getStockQuantity());
    }

    private PerfumeEntity createTestPerfume(int initialStock) {
        return new PerfumeEntity(
            new PerfumeId(UUID.randomUUID().toString()),
            "Oud Ispahan",
            new BigDecimal("250.00"),
            new ScentProfile("Labdanum", "Patchouli", "Oud"),
            new BottleVolume(100),
            Concentration.EAU_DE_PARFUM,
            initialStock
        );
    }
}
