package com.erp.core.web.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

/**
 * Thrown when a request cannot be processed due to a client-side error.
 */
public class BadRequestAlertException extends ApiException {

    public BadRequestAlertException(String code, String message) {
        super(HttpStatus.BAD_REQUEST, code, message);
    }

    public BadRequestAlertException(HttpStatusCode status, String code, String message) {
        super(status, code, message);
    }
}
