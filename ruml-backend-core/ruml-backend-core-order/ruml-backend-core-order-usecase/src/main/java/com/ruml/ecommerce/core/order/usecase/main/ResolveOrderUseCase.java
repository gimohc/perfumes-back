package com.ruml.ecommerce.core.order.usecase.main;
import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;
import com.ruml.ecommerce.core.order.dao.OrderDao;
import com.ruml.ecommerce.core.order.factory.request.ResolveOrderRequest;
import com.ruml.ecommerce.core.order.factory.response.ResolveOrderResponse;
import jakarta.validation.Validator;
public class ResolveOrderUseCase extends FunctionalUseCase<ResolveOrderRequest, ResolveOrderResponse> {
    private final OrderDao orderDao;
    public ResolveOrderUseCase(Validator validator, OrderDao orderDao) {
        super(validator);
        this.orderDao = orderDao;
    }
    @Override
    protected ResolveOrderResponse doExecute(ResolveOrderRequest request) {
        var order = orderDao.findByOrderId(request.orderId())
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        var updater = orderDao.updater(order)
                .status(request.status());
        var updatedIdentity = updater.update();
        return new ResolveOrderResponse(true, updatedIdentity.status());
    }
}
