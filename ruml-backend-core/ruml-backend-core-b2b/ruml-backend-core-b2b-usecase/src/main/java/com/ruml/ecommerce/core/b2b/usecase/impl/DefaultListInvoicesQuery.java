package com.ruml.ecommerce.core.b2b.usecase.impl;

import com.ruml.ecommerce.core.b2b.factory.request.ListInvoicesRequest;
import com.ruml.ecommerce.core.b2b.factory.response.ListInvoicesResponse;
import com.ruml.ecommerce.core.b2b.port.QuoteReadPort;
import com.ruml.ecommerce.core.b2b.usecase.ListInvoicesQuery;

public class DefaultListInvoicesQuery implements ListInvoicesQuery {

    private final QuoteReadPort quoteReadPort;

    public DefaultListInvoicesQuery(QuoteReadPort quoteReadPort) {
        this.quoteReadPort = quoteReadPort;
    }

    @Override
    public ListInvoicesResponse execute(ListInvoicesRequest request) {
        return new ListInvoicesResponse(quoteReadPort.findInvoices(request.query()));
    }
}
