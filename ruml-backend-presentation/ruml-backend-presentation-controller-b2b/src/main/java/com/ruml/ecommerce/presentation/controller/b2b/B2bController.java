package com.ruml.ecommerce.presentation.controller.b2b;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.ruml.ecommerce.core.b2b.factory.request.SubmitQuoteRequest;
import com.ruml.ecommerce.core.b2b.factory.request.ListInvoicesRequest;
import com.ruml.ecommerce.core.b2b.factory.response.SubmitQuoteResponse;
import com.ruml.ecommerce.core.b2b.factory.response.ListInvoicesResponse;
import com.ruml.ecommerce.core.b2b.usecase.SubmitQuoteUseCase;
import com.ruml.ecommerce.core.b2b.usecase.ListInvoicesQuery;
import com.ruml.ecommerce.core.shared.entity.pagination.PageQuery;

@RestController
@Tag(name = "B2B", description = "B2B Quotes & Invoices API")
@RequestMapping("/api/b2b")
public class B2bController {

    private final SubmitQuoteUseCase submitQuoteUseCase;
    private final ListInvoicesQuery listInvoicesQuery;

    public B2bController(SubmitQuoteUseCase submitQuoteUseCase, ListInvoicesQuery listInvoicesQuery) {
        this.submitQuoteUseCase = submitQuoteUseCase;
        this.listInvoicesQuery = listInvoicesQuery;
    }

    @PostMapping("/quotes")
    @Operation(summary = "Submit a new B2B bespoke quote")
    public ResponseEntity<SubmitQuoteResponse> submitQuote(@RequestBody SubmitQuoteRequest request) {
        SubmitQuoteResponse response = submitQuoteUseCase.execute(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/invoices")
    @Operation(summary = "List all generated invoices")
    public ResponseEntity<ListInvoicesResponse> listInvoices(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "DESC") String sortDirection) {
        
        PageQuery query = new PageQuery(page, size, sortBy, sortDirection);
        ListInvoicesResponse response = listInvoicesQuery.execute(new ListInvoicesRequest(query));
        return ResponseEntity.ok(response);
    }
}
