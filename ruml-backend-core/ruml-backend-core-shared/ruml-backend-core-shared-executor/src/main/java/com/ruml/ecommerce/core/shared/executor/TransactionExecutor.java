package com.ruml.ecommerce.core.shared.executor;
import java.util.function.Supplier;
public interface TransactionExecutor {
    <T> T executeInTransaction(Supplier<T> supplier);
}
