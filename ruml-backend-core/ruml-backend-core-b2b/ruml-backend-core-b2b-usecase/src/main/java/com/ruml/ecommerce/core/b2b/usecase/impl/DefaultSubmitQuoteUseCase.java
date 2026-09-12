package com.ruml.ecommerce.core.b2b.usecase.impl;

import com.ruml.ecommerce.core.b2b.entity.B2BQuoteEntity;
import com.ruml.ecommerce.core.b2b.entity.B2BQuoteId;
import com.ruml.ecommerce.core.b2b.factory.request.SubmitQuoteRequest;
import com.ruml.ecommerce.core.b2b.factory.response.SubmitQuoteResponse;
import com.ruml.ecommerce.core.b2b.port.B2BQuotePort;
import com.ruml.ecommerce.core.b2b.usecase.SubmitQuoteUseCase;
import com.ruml.ecommerce.core.shared.exception.DomainException;

public class DefaultSubmitQuoteUseCase implements SubmitQuoteUseCase {

    private final B2BQuotePort quotePort;

    public DefaultSubmitQuoteUseCase(B2BQuotePort quotePort) {
        this.quotePort = quotePort;
    }

    @Override
    public SubmitQuoteResponse execute(SubmitQuoteRequest request) {
        B2BQuoteEntity quote = new B2BQuoteEntity(
            new B2BQuoteId(java.util.UUID.randomUUID().toString()),
            request.customerEmail(),
            request.companyName()
        );
        
        for (SubmitQuoteRequest.QuoteItemRequest itemReq : request.items()) {
            quote.addItem(new com.ruml.ecommerce.core.b2b.entity.QuoteItem(
                itemReq.perfumeId(),
                itemReq.quantity()
            ));
        }
            
        quote.submit();
        B2BQuoteEntity saved = quotePort.save(quote);
        
        com.ruml.ecommerce.core.b2b.entity.readmodel.QuoteReadModel readModel = 
            new com.ruml.ecommerce.core.b2b.entity.readmodel.QuoteReadModel(
                saved.getId().value(),
                saved.getCustomerEmail(),
                saved.getCompanyName(),
                saved.getStatus(),
                saved.getItems(),
                saved.getTerms()
            );
        
        return new SubmitQuoteResponse(readModel);
    }
}
