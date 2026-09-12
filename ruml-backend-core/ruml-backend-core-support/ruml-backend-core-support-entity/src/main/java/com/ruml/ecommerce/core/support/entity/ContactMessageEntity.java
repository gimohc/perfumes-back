package com.ruml.ecommerce.core.support.entity;

import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.support.identity.SupportId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@jakarta.persistence.Entity
@Table(name = "contact_messages")
public class ContactMessageEntity implements Entity<SupportId> {
    
    @EmbeddedId
    private SupportId id;

    @Column(nullable = false)
    private String senderEmail;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String messageBody;

    @Column(nullable = false)
    private boolean replied;

    protected ContactMessageEntity() {
        // JPA requires default constructor
    }

    public ContactMessageEntity(SupportId id, String senderEmail, String subject, String messageBody) {
        this.id = id;
        this.senderEmail = senderEmail;
        this.subject = subject;
        this.messageBody = messageBody;
        this.replied = false;
    }

    @Override
    public SupportId getId() {
        return id;
    }

    public String getSenderEmail() { return senderEmail; }
    public String getSubject() { return subject; }
    public String getMessageBody() { return messageBody; }
    public boolean isReplied() { return replied; }

    public void markAsReplied() {
        this.replied = true;
    }
}
