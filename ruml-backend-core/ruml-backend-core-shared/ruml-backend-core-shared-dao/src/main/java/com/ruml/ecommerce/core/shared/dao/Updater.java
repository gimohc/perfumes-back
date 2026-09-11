package com.ruml.ecommerce.core.shared.dao;

public interface Updater<T> {
    void update(T entity);
}
