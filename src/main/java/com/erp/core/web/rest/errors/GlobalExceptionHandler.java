package com.erp.core.web.rest.errors;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Translates core exceptions and bean-validation failures into RFC 7807
 * {@link ProblemDetail} responses. Registered by component scan of
 * {@code com.erp.core.web.rest} (via {@link com.erp.core.CoreApplication}).
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ProblemDetail handleApiException(ApiException ex) {
        HttpStatusCode status = ex.getStatus();
        ProblemDetail problem = ProblemDetail.forStatus(status);
        problem.setTitle(status instanceof HttpStatus httpStatus ? httpStatus.getReasonPhrase() : status.toString());
        problem.setDetail(ex.getMessage());
        problem.setProperty("code", ex.getCode());
        return problem;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException ex) {
        HttpStatusCode status = HttpStatus.BAD_REQUEST;
        ProblemDetail problem = ex.getBody();
        if (problem == null) {
            problem = ProblemDetail.forStatus(status);
        }
        problem.setTitle("Validation failed");
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            fieldErrors.put(error.getField(), error.getDefaultMessage()));
        problem.setProperty("fieldErrors", fieldErrors);
        return problem;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleUnexpected(Exception ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problem.setTitle("Internal Server Error");
        problem.setDetail(ex.getMessage());
        return problem;
    }
}
