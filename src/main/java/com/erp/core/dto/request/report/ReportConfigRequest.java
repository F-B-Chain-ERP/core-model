package com.erp.core.dto.request.report;

/**
 * Yêu cầu lấy cấu hình xuất báo cáo cho Frontend (module/report cụ thể).
 *
 * <p>Hiện tại hệ thống dùng 1 cấu hình toàn cục nên request có thể rỗng.
 * Tham số module/reportType để sau này mở rộng cho mỗi phân hệ có ngưỡng riêng
 * (POS, STORE, FIN, INV, PROC...).</p>
 *
 * @param module     mã phân hệ (POS, STORE, FIN, INV, PROC) — không bắt buộc
 * @param reportType loại báo cáo (ORDER_LIST, STORE_SHIFT_REPORT...) — không bắt buộc
 */
public record ReportConfigRequest(String module, String reportType) {
}
