package com.erp.core.dto.response.notification;

import java.time.Instant;
import java.util.UUID;

/**
 * Phản hồi thông tin thông báo (Notification) cho client.
 */
public record NotificationResponse(
        UUID id,
        UUID accountId,
        String title,
        String body,
        String status,
        Instant sentAt,
        Instant readAt,
        Instant createdAt,
        String actionUrl,
        String type
) {
}
