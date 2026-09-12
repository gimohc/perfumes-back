package com.ruml.ecommerce.core.b2b.entity.readmodel;

import com.ruml.ecommerce.core.b2b.entity.QuoteItem;
import com.ruml.ecommerce.core.b2b.entity.QuoteStatus;
import com.ruml.ecommerce.core.b2b.entity.NegotiatedTerms;

import java.util.List;

public record QuoteReadModel(
        String quoteId,
        String customerEmail,
        String companyName,
        QuoteStatus status,
        List<QuoteItem> items,
        NegotiatedTerms terms
) {}
