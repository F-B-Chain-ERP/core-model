package com.erp.core.dto.response.notification;

/**
 * Phản hồi vé kết nối SSE (short-lived single-use ticket).
 */
public record SseTicketResponse(
        String ticket,
        long expiresInSeconds
) {
}
