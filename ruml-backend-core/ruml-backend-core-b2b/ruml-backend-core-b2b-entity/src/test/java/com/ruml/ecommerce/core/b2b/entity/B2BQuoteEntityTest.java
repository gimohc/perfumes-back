package com.ruml.ecommerce.core.b2b.entity;

import com.ruml.ecommerce.core.shared.exception.DomainException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class B2BQuoteEntityTest {

    @Test
    void shouldCreateInDraftState() {
        B2BQuoteEntity quote = createTestQuote();
        assertEquals(QuoteStatus.DRAFT, quote.getStatus());
    }

    @Test
    void shouldSubmitSuccessfullyWhenDraftWithItems() {
        B2BQuoteEntity quote = createTestQuote();
        quote.addItem(new QuoteItem("Oud Ispahan", 50));
        
        quote.submit();
        
        assertEquals(QuoteStatus.SUBMITTED, quote.getStatus());
    }

    @Test
    void shouldThrowExceptionWhenSubmittingEmptyQuote() {
        B2BQuoteEntity quote = createTestQuote();
        
        DomainException ex = assertThrows(DomainException.class, quote::submit);
        assertEquals("EMPTY_QUOTE", ex.getCode());
    }

    @Test
    void shouldThrowExceptionWhenAddingItemsToNonDraft() {
        B2BQuoteEntity quote = createTestQuote();
        quote.addItem(new QuoteItem("Oud Ispahan", 50));
        quote.submit();
        
        DomainException ex = assertThrows(DomainException.class, () -> 
            quote.addItem(new QuoteItem("Ambre Nuit", 20))
        );
        assertEquals("INVALID_STATE", ex.getCode());
    }

    @Test
    void shouldNegotiateSuccessfullyFromSubmitted() {
        B2BQuoteEntity quote = createTestQuote();
        quote.addItem(new QuoteItem("Oud Ispahan", 50));
        quote.submit();
        
        NegotiatedTerms terms = new NegotiatedTerms(new BigDecimal("1000.00"), 50, Instant.now().plus(7, ChronoUnit.DAYS));
        quote.negotiate(terms);
        
        assertEquals(QuoteStatus.IN_NEGOTIATION, quote.getStatus());
        assertEquals(terms, quote.getTerms());
    }

    @Test
    void shouldThrowExceptionWhenNegotiatingDraft() {
        B2BQuoteEntity quote = createTestQuote();
        
        NegotiatedTerms terms = new NegotiatedTerms(new BigDecimal("1000.00"), 50, Instant.now().plus(7, ChronoUnit.DAYS));
        DomainException ex = assertThrows(DomainException.class, () -> quote.negotiate(terms));
        
        assertEquals("INVALID_TRANSITION", ex.getCode());
    }

    private B2BQuoteEntity createTestQuote() {
        return new B2BQuoteEntity(
            new B2BQuoteId(UUID.randomUUID().toString()),
            "corporate@example.com",
            "Example Corp"
        );
    }
}
