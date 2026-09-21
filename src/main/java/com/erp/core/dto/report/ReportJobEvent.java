package com.erp.core.dto.report;

import java.time.Instant;
import java.util.UUID;

/**
 * Payload sự kiện realtime cho các tiến trình xuất báo cáo (kênh SSE 'report_event' & Redis).
 */
public record ReportJobEvent(
        UUID jobId,
        String reportType,
        String status,
        String fileName,
        String downloadUrl,
        String errorCode,
        String errorMessage,
        Instant completedAt
) {
}
