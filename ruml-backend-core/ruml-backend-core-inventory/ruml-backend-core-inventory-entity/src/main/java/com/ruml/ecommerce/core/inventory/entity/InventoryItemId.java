package com.ruml.ecommerce.core.inventory.entity;

import com.ruml.ecommerce.core.shared.identity.Identity;
import java.io.Serializable;

public record InventoryItemId(String value) implements Identity<String>, Serializable {}
