package com.ruml.ecommerce.core.inventory.factory.response;

public record DeductStockResponse(String inventoryItemId, int totalStock, int reservedStock) {}
