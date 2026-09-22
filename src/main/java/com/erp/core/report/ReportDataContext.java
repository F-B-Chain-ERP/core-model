package com.erp.core.report;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Ngữ cảnh dữ liệu chuẩn dùng để kết xuất báo cáo — là Data Contract duy nhất
 * cho cả Excel và PDF, tách biệt hoàn toàn tầng truy vấn dữ liệu khỏi tầng vẽ file.
 *
 * <p>Nằm trong core-model để backend-service và queue-service dùng chung một hợp đồng.</p>
 *
 * @param title         tiêu đề chính của báo cáo (in hoa trên file)
 * @param subtitle      tiêu đề phụ (chi nhánh, phạm vi thời gian...)
 * @param logoPath      đường dẫn file logo thương hiệu nhúng vào header (vd: C:/ERP-UTT/image.png)
 * @param metadata      thông tin phi kỹ thuật (người xuất, chi nhánh, thời gian, người bàn giao...)
 * @param columns       danh sách cột bảng dữ liệu
 * @param rows          dữ liệu dòng chi tiết
 * @param summary       dòng tổng cộng / thông tin tổng hợp ở cuối bảng (Map hoặc List)
 * @param secondaryData bảng phụ kèm theo (vd: chi tiết 9 mệnh giá tiền mặt VNĐ, kênh thanh toán)
 */
public record ReportDataContext(
        String title,
        String subtitle,
        String logoPath,
        Map<String, Object> metadata,
        List<ReportColumnDefinition> columns,
        List<Map<String, Object>> rows,
        Object summary,
        List<Map<String, Object>> secondaryData
) {

    public ReportDataContext {
        columns = columns != null ? List.copyOf(columns) : Collections.emptyList();
        rows = rows != null ? rows : Collections.emptyList();
        secondaryData = secondaryData != null ? List.copyOf(secondaryData) : Collections.emptyList();
    }

    /** Factory tiện lợi cho báo cáo không có logo/bảng phụ (giữ tương thích luồng Sync đơn giản). */
    public static ReportDataContext simple(String title, String subtitle,
                                           List<ReportColumnDefinition> columns,
                                           List<Map<String, Object>> rows) {
        return new ReportDataContext(title, subtitle, null, Map.of(),
                columns, rows, null, List.of());
    }
}
