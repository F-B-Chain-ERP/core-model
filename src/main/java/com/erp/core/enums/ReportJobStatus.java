package com.erp.core.enums;

import java.util.Set;

/**
 * Trạng thái của một công việc xuất báo cáo nền (Report Job).
 */
public enum ReportJobStatus {
    /** Đang chờ xử lý trong hàng đợi RabbitMQ. */
    PENDING,

    /** Worker đã nhận và đang xử lý/truy vấn/vẽ file. */
    PROCESSING,

    /** Hoàn thành xuất file và đã upload lên storage thành công. */
    DONE,

    /** Xử lý thất bại hoặc lỗi hệ thống. */
    FAILED,

    /** Người dùng đã chủ động hủy job trước hoặc trong khi xử lý. */
    CANCELLED,

    /** Báo cáo quá hạn lưu trữ (retention) hoặc timeout không thể khôi phục. */
    EXPIRED;

    private static final Set<ReportJobStatus> TERMINAL_STATUSES = Set.of(DONE, FAILED, CANCELLED, EXPIRED);

    /** Kiểm tra xem job đã đạt trạng thái kết thúc (không thay đổi trạng thái nữa) hay chưa. */
    public boolean isTerminal() {
        return TERMINAL_STATUSES.contains(this);
    }

    public static ReportJobStatus from(String name) {
        if (name == null || name.isBlank()) {
            return null;
        }
        try {
            return ReportJobStatus.valueOf(name.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
