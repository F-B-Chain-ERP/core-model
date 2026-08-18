package com.erp.core.web.rest.errors;

import org.springframework.http.HttpStatusCode;

/**
 * Base runtime exception carrying an HTTP status and a stable application error code.
 * Subclasses provide specific semantics. Translated to an RFC 7807
 * {@code ProblemDetail} by {@link GlobalExceptionHandler}.
 */
public class ApiException extends RuntimeException {

    private final HttpStatusCode status;
    private final String code;

    public ApiException(HttpStatusCode status, String code, String message) {
        super(message);
        this.status = status;
        this.code = code;
    }

    public ApiException(HttpStatusCode status, String code, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.code = code;
    }

    public HttpStatusCode getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }
}
