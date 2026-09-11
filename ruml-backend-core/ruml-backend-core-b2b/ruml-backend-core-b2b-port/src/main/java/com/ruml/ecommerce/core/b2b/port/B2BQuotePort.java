package com.ruml.ecommerce.core.b2b.port;

import com.ruml.ecommerce.core.b2b.entity.B2BQuoteEntity;
import com.ruml.ecommerce.core.b2b.entity.B2BQuoteId;
import java.util.Optional;

public interface B2BQuotePort {
    B2BQuoteEntity save(B2BQuoteEntity quote);
    Optional<B2BQuoteEntity> findById(B2BQuoteId id);
}
