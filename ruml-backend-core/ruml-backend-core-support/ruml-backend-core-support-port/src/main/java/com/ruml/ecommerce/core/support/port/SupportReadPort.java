package com.ruml.ecommerce.core.support.port;

import com.ruml.ecommerce.core.support.entity.readmodel.ContactMessageReadModel;
import com.ruml.ecommerce.core.shared.entity.pagination.PageQuery;
import com.ruml.ecommerce.core.shared.entity.pagination.PageResult;

public interface SupportReadPort {
    PageResult<ContactMessageReadModel> findMessages(PageQuery query);
}
