package com.ruml.ecommerce.core.shared.executor.impl;

import com.ruml.ecommerce.core.shared.executor.TransactionExecutor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@Component
public class SpringTransactionExecutor implements TransactionExecutor {

    @Override
    @Transactional
    public <T> T executeInTransaction(Supplier<T> operation) {
        return operation.get();
    }

    @Override
    @Transactional
    public void executeInTransaction(Runnable operation) {
        operation.run();
    }
}
