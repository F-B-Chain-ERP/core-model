package com.erp.core.dto.response;

import java.time.Instant;

/**
 * Standard API response wrapper.
 */
public record ApiResponse<T>(
        int status,
        String errorCode,
        String message,
        T data,
        Instant timestamp
) {

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, null, "Success", data, Instant.now());
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(200, null, message, data, Instant.now());
    }

    public static <T> ApiResponse<T> error(int status, String errorCode, String message) {
        return new ApiResponse<>(status, errorCode, message, null, Instant.now());
    }
    public static <T> ApiResponse<T> created(T data) {
        return new ApiResponse<>(201, null, "Created", data, Instant.now());
    }
}
