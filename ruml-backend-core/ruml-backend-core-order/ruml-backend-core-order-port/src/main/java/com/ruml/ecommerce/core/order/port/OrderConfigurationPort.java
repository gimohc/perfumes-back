package com.ruml.ecommerce.core.order.port;
import com.ruml.ecommerce.core.order.dao.OrderDao;
import com.ruml.ecommerce.core.order.function.OrderIdGenerator;
import com.ruml.ecommerce.core.order.usecase.main.PlaceOrderUseCase;
import com.ruml.ecommerce.core.order.usecase.main.ResolveOrderUseCase;
import com.ruml.ecommerce.core.shared.executor.TransactionExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import jakarta.validation.Validator;
@Configuration
public class OrderConfigurationPort {
    @Bean
    public PlaceOrderUseCase placeOrderUseCase(Validator validator, OrderDao orderDao, OrderIdGenerator orderIdGenerator, TransactionExecutor txExecutor) {
        return new PlaceOrderUseCase(validator, orderDao, orderIdGenerator, txExecutor);
    }
    @Bean
    public ResolveOrderUseCase resolveOrderUseCase(Validator validator, OrderDao orderDao) {
        return new ResolveOrderUseCase(validator, orderDao);
    }
}
