package com.ruml.ecommerce.core.support.usecase.impl;

import com.ruml.ecommerce.core.support.factory.request.SubmitContactFormRequest;
import com.ruml.ecommerce.core.support.factory.response.SubmitContactFormResponse;
import com.ruml.ecommerce.core.support.port.SupportPort;
import com.ruml.ecommerce.core.support.entity.ContactMessageEntity;
import com.ruml.ecommerce.core.support.identity.SupportId;
import com.ruml.ecommerce.core.support.usecase.SubmitContactFormUseCase;
import com.ruml.ecommerce.core.support.entity.readmodel.ContactMessageReadModel;

public class DefaultSubmitContactFormUseCase implements SubmitContactFormUseCase {

    private final SupportPort supportPort;

    public DefaultSubmitContactFormUseCase(SupportPort supportPort) {
        this.supportPort = supportPort;
    }

    @Override
    public SubmitContactFormResponse execute(SubmitContactFormRequest request) {
        ContactMessageEntity message = new ContactMessageEntity(
            new SupportId(java.util.UUID.randomUUID().toString()),
            request.senderEmail(),
            request.subject(),
            request.messageBody()
        );
        
        ContactMessageEntity saved = supportPort.save(message);
        ContactMessageReadModel readModel = new ContactMessageReadModel(
            saved.getId().value(),
            saved.getSenderEmail(),
            saved.getSubject(),
            saved.getMessageBody(),
            saved.isReplied()
        );
        
        return new SubmitContactFormResponse(readModel);
    }
}
