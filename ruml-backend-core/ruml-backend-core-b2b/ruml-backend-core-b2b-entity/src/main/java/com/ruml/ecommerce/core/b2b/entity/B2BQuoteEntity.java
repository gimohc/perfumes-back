package com.ruml.ecommerce.core.b2b.entity;

import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.shared.exception.DomainException;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@jakarta.persistence.Entity
@Table(name = "b2b_quotes")
public class B2BQuoteEntity implements Entity<B2BQuoteId> {

    @EmbeddedId
    private B2BQuoteId id;

    private String customerEmail;
    private String companyName;

    @Enumerated(EnumType.STRING)
    private QuoteStatus status;

    @ElementCollection
    private List<QuoteItem> items = new ArrayList<>();

    @Embedded
    private NegotiatedTerms terms;

    protected B2BQuoteEntity() {}

    public B2BQuoteEntity(B2BQuoteId id, String customerEmail, String companyName) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.companyName = companyName;
        this.status = QuoteStatus.DRAFT;
    }

    @Override
    public B2BQuoteId getId() {
        return id;
    }

    public void addItem(QuoteItem item) {
        if (this.status != QuoteStatus.DRAFT) {
            throw new DomainException("INVALID_STATE", "Items can only be added to a DRAFT quote");
        }
        this.items.add(item);
    }

    public void submit() {
        if (this.status != QuoteStatus.DRAFT) {
            throw new DomainException("INVALID_TRANSITION", "Only DRAFT quotes can be submitted");
        }
        if (this.items.isEmpty()) {
            throw new DomainException("EMPTY_QUOTE", "Cannot submit an empty quote");
        }
        this.status = QuoteStatus.SUBMITTED;
    }

    public void negotiate(NegotiatedTerms terms) {
        if (this.status != QuoteStatus.SUBMITTED && this.status != QuoteStatus.IN_NEGOTIATION) {
            throw new DomainException("INVALID_TRANSITION", "Quote must be SUBMITTED or IN_NEGOTIATION to negotiate");
        }
        this.terms = terms;
        this.status = QuoteStatus.IN_NEGOTIATION;
    }

    public void approve() {
        if (this.status != QuoteStatus.IN_NEGOTIATION) {
            throw new DomainException("INVALID_TRANSITION", "Only quotes IN_NEGOTIATION can be approved");
        }
        this.status = QuoteStatus.APPROVED;
    }
    
    public void reject() {
        if (this.status != QuoteStatus.IN_NEGOTIATION && this.status != QuoteStatus.SUBMITTED) {
            throw new DomainException("INVALID_TRANSITION", "Quote must be SUBMITTED or IN_NEGOTIATION to reject");
        }
        this.status = QuoteStatus.REJECTED;
    }

    // Getters
    public String getCustomerEmail() { return customerEmail; }
    public String getCompanyName() { return companyName; }
    public QuoteStatus getStatus() { return status; }
    public List<QuoteItem> getItems() { return List.copyOf(items); }
    public NegotiatedTerms getTerms() { return terms; }
}
