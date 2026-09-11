package com.ruml.ecommerce.presentation.controller.shared;

import com.ruml.ecommerce.core.shared.exception.DomainException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void testHandleDomainException() {
        DomainException ex = new DomainException("TEST_CODE", "Test message");
        ProblemDetail result = handler.handleDomainException(ex);

        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
        assertEquals("Test message", result.getDetail());
        assertEquals("https://api.rumlscents.com/errors/TEST_CODE", result.getType().toString());
    }

    @Test
    void testHandleIllegalArgumentException() {
        IllegalArgumentException ex = new IllegalArgumentException("Invalid arg");
        ProblemDetail result = handler.handleIllegalArgumentException(ex);

        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
        assertEquals("Invalid arg", result.getDetail());
    }

    @Test
    void testHandleGenericException() {
        Exception ex = new Exception("Secret internal error");
        ProblemDetail result = handler.handleGenericException(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), result.getStatus());
        // Verify we don't leak the real exception message
        assertEquals("An unexpected internal server error occurred.", result.getDetail());
    }
}
