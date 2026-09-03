package com.ruml.ecommerce.core.order.usecase.main;
import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;
import com.ruml.ecommerce.core.shared.executor.TransactionExecutor;
import com.ruml.ecommerce.core.order.dao.OrderDao;
import com.ruml.ecommerce.core.order.factory.request.PlaceOrderRequest;
import com.ruml.ecommerce.core.order.factory.response.PlaceOrderResponse;
import com.ruml.ecommerce.core.order.function.OrderIdGenerator;
import jakarta.validation.Validator;
public class PlaceOrderUseCase extends FunctionalUseCase<PlaceOrderRequest, PlaceOrderResponse> {
    private final OrderDao orderDao;
    private final OrderIdGenerator orderIdGenerator;
    private final TransactionExecutor txExecutor;
    public PlaceOrderUseCase(Validator validator, OrderDao orderDao, OrderIdGenerator orderIdGenerator, TransactionExecutor txExecutor) {
        super(validator);
        this.orderDao = orderDao;
        this.orderIdGenerator = orderIdGenerator;
        this.txExecutor = txExecutor;
    }
    @Override
    protected PlaceOrderResponse doExecute(PlaceOrderRequest request) {
        return txExecutor.executeInTransaction(() -> {
            String newOrderId = orderIdGenerator.generate();
            var creator = orderDao.creator()
                .orderId(newOrderId)
                .customerName(request.customer().name())
                .customerEmail(request.customer().email())
                .customerPhone(request.customer().phone())
                .shippingAddress(request.customer().address() + ", " + request.customer().city())
                .paymentMethod(request.paymentMethod())
                .subtotal(request.subtotal())
                .shippingFee(request.shipping())
                .total(request.total())
                .status("Pending");
            request.items().forEach(item -> 
                creator.addItem(item.id(), item.type(), item.name(), item.price(), item.quantity())
            );
            creator.create();
            return new PlaceOrderResponse(true, newOrderId);
        });
    }
}
