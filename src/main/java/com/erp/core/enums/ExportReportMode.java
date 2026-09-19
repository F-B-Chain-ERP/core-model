package com.erp.core.enums;

/**
 * Chế độ điều phối khi xuất báo cáo.
 *
 * <ul>
 *   <li>{@code AUTO} (mặc định): tự đếm số bản ghi, nhỏ hơn {@code async-threshold-records}
 *       thì xử lý đồng bộ, ngược lại xử lý bất đồng bộ.</li>
 *   <li>{@code SYNC}: ép xử lý đồng bộ (chỉ hợp lệ khi số bản ghi &lt;= {@code max-hard-sync-records}).</li>
 *   <li>{@code ASYNC}: ép xử lý bất đồng bộ (tạo job, đẩy RabbitMQ, thông báo qua SSE/Polling).</li>
 * </ul>
 */
public enum ExportReportMode {
    AUTO,
    SYNC,
    ASYNC
}
