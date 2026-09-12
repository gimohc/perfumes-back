package com.ruml.ecommerce.core.support.usecase.impl;

import com.ruml.ecommerce.core.support.factory.request.GetMessagesRequest;
import com.ruml.ecommerce.core.support.factory.response.GetMessagesResponse;
import com.ruml.ecommerce.core.support.port.SupportReadPort;
import com.ruml.ecommerce.core.support.usecase.GetMessagesUseCase;

public class DefaultGetMessagesUseCase implements GetMessagesUseCase {

    private final SupportReadPort supportReadPort;

    public DefaultGetMessagesUseCase(SupportReadPort supportReadPort) {
        this.supportReadPort = supportReadPort;
    }

    @Override
    public GetMessagesResponse execute(GetMessagesRequest request) {
        return new GetMessagesResponse(supportReadPort.findMessages(request.query()));
    }
}
