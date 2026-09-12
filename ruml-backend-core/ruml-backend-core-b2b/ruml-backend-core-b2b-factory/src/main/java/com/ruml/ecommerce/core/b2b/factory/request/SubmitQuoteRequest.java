package com.ruml.ecommerce.core.b2b.factory.request;

import java.util.List;

public record SubmitQuoteRequest(
        String customerEmail,
        String companyName,
        List<QuoteItemRequest> items
) {
    public record QuoteItemRequest(String perfumeId, int quantity) {}
}
