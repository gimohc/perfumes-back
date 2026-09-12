package com.ruml.ecommerce.core.support.port;

import com.ruml.ecommerce.core.support.entity.ContactMessageEntity;
import com.ruml.ecommerce.core.support.identity.SupportId;
import java.util.Optional;

public interface SupportPort {
    Optional<ContactMessageEntity> findById(SupportId id);
    ContactMessageEntity save(ContactMessageEntity message);
}
