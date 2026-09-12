package com.ruml.ecommerce.presentation.controller.support;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import com.ruml.ecommerce.core.support.factory.request.GetMessagesRequest;
import com.ruml.ecommerce.core.support.factory.request.SubmitContactFormRequest;
import com.ruml.ecommerce.core.support.factory.response.GetMessagesResponse;
import com.ruml.ecommerce.core.support.factory.response.SubmitContactFormResponse;
import com.ruml.ecommerce.core.support.usecase.GetMessagesUseCase;
import com.ruml.ecommerce.core.support.usecase.SubmitContactFormUseCase;
import com.ruml.ecommerce.core.shared.entity.pagination.PageQuery;

@RestController
@Tag(name = "Support", description = "Customer Support API")
@RequestMapping("/api")
public class SupportController {

    private final SubmitContactFormUseCase submitContactFormUseCase;
    private final GetMessagesUseCase getMessagesUseCase;

    public SupportController(SubmitContactFormUseCase submitContactFormUseCase, GetMessagesUseCase getMessagesUseCase) {
        this.submitContactFormUseCase = submitContactFormUseCase;
        this.getMessagesUseCase = getMessagesUseCase;
    }

    @PostMapping("/contact")
    @Operation(summary = "Submit a contact message")
    public ResponseEntity<SubmitContactFormResponse> submitContactForm(@RequestBody SubmitContactFormRequest request) {
        SubmitContactFormResponse response = submitContactFormUseCase.execute(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/admin/messages")
    @Operation(summary = "List customer messages")
    public ResponseEntity<GetMessagesResponse> getMessages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "DESC") String sortDirection) {
        
        PageQuery query = new PageQuery(page, size, sortBy, sortDirection);
        GetMessagesResponse response = getMessagesUseCase.execute(new GetMessagesRequest(query));
        return ResponseEntity.ok(response);
    }
}
