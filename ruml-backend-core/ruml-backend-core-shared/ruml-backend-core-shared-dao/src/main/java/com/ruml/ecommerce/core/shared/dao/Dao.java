package com.ruml.ecommerce.core.shared.dao;
public interface Dao<I, C, U> {
    C creator();
    U updater(I identity);
}
