package com.ruml.ecommerce.core.order.dao;
import com.ruml.ecommerce.core.shared.dao.Updater;
import com.ruml.ecommerce.core.order.identity.OrderIdentity;
public interface OrderUpdater extends Updater<OrderIdentity> {
    OrderUpdater status(String status);
}
