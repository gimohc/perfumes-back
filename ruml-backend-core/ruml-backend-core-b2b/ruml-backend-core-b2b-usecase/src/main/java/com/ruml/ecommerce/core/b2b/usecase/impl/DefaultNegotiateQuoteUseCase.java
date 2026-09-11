package com.ruml.ecommerce.core.b2b.usecase.impl;

import com.ruml.ecommerce.core.b2b.entity.B2BQuoteEntity;
import com.ruml.ecommerce.core.b2b.entity.B2BQuoteId;
import com.ruml.ecommerce.core.b2b.entity.NegotiatedTerms;
import com.ruml.ecommerce.core.b2b.factory.request.NegotiateQuoteRequest;
import com.ruml.ecommerce.core.b2b.factory.response.NegotiateQuoteResponse;
import com.ruml.ecommerce.core.b2b.port.B2BQuotePort;
import com.ruml.ecommerce.core.b2b.usecase.NegotiateQuoteUseCase;
import com.ruml.ecommerce.core.shared.exception.DomainException;

public class DefaultNegotiateQuoteUseCase implements NegotiateQuoteUseCase {

    private final B2BQuotePort quotePort;

    public DefaultNegotiateQuoteUseCase(B2BQuotePort quotePort) {
        this.quotePort = quotePort;
    }

    @Override
    public NegotiateQuoteResponse execute(NegotiateQuoteRequest request) {
        B2BQuoteEntity quote = quotePort.findById(new B2BQuoteId(request.quoteId()))
            .orElseThrow(() -> new DomainException("QUOTE_NOT_FOUND", "Quote not found"));
            
        NegotiatedTerms terms = new NegotiatedTerms(
            request.customPrice(),
            request.minOrderQuantity(),
            request.expirationDate()
        );
            
        quote.negotiate(terms);
        B2BQuoteEntity saved = quotePort.save(quote);
        
        return new NegotiateQuoteResponse(saved.getId().value(), saved.getStatus().name());
    }
}
