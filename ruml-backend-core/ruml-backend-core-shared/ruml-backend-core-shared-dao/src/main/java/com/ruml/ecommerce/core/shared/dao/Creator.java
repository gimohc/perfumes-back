package com.ruml.ecommerce.core.shared.dao;

public interface Creator<T> {
    void create(T entity);
}
