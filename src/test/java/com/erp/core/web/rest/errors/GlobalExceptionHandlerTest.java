package com.erp.core.web.rest.errors;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void apiExceptionIsTranslatedToProblemDetail() {
        ApiException ex = new BadRequestAlertException("err.invalid", "payload is invalid");
        ProblemDetail pd = handler.handleApiException(ex);

        assertThat(pd.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(pd.getTitle()).isEqualTo("Bad Request");
        assertThat(pd.getDetail()).isEqualTo("payload is invalid");
        assertThat(pd.getProperties().get("code")).isEqualTo("err.invalid");
    }

    @Test
    void resourceNotFoundMapsTo404() {
        ResourceNotFoundException ex = new ResourceNotFoundException("err.not_found", "account 123");
        ProblemDetail pd = handler.handleApiException(ex);

        assertThat(pd.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(pd.getTitle()).isEqualTo("Not Found");
        assertThat(pd.getProperties().get("code")).isEqualTo("err.not_found");
    }

    @Test
    void unexpectedExceptionMapsTo500() {
        ProblemDetail pd = handler.handleUnexpected(new IllegalStateException("boom"));

        assertThat(pd.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(pd.getTitle()).isEqualTo("Internal Server Error");
    }
}
