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
        B2BQuoteEntity quote = quotePort.findById(new B2BQuoteId(request.quoteId()))
            .orElseThrow(() -> new DomainException("QUOTE_NOT_FOUND", "Quote not found"));
            
        quote.submit();
        B2BQuoteEntity saved = quotePort.save(quote);
        
        return new SubmitQuoteResponse(saved.getId().value(), saved.getStatus().name());
    }
}
