package com.ruml.ecommerce.core.support.factory.response;

import com.ruml.ecommerce.core.support.entity.readmodel.ContactMessageReadModel;
import com.ruml.ecommerce.core.shared.entity.pagination.PageResult;

public record GetMessagesResponse(PageResult<ContactMessageReadModel> page) {}
