package com.erp.core.report;

/**
 * Định nghĩa một cột trong bảng dữ liệu báo cáo — là hợp đồng dùng chung giữa
 * backend-service (điều phối), queue-service (worker xuất file) và Frontend.
 *
 * @param key    key của trường dữ liệu trong từng row (Map)
 * @param header tiêu đề cột xuất ra file
 * @param width  độ rộng cột (đơn vị tương đối — Excel: đơn vị ký tự, PDF: tỷ lệ %)
 * @param type   kiểu dữ liệu để định dạng ô phù hợp (currency, number, date...)
 */
public record ReportColumnDefinition(
        String key,
        String header,
        int width,
        ColumnType type
) {

    public enum ColumnType {
        TEXT,
        NUMBER,
        CURRENCY,
        DATE,
        DATETIME
    }

    public static ReportColumnDefinition text(String key, String header, int width) {
        return new ReportColumnDefinition(key, header, width, ColumnType.TEXT);
    }

    public static ReportColumnDefinition number(String key, String header, int width) {
        return new ReportColumnDefinition(key, header, width, ColumnType.NUMBER);
    }

    public static ReportColumnDefinition currency(String key, String header, int width) {
        return new ReportColumnDefinition(key, header, width, ColumnType.CURRENCY);
    }

    public static ReportColumnDefinition date(String key, String header, int width) {
        return new ReportColumnDefinition(key, header, width, ColumnType.DATE);
    }

    public static ReportColumnDefinition dateTime(String key, String header, int width) {
        return new ReportColumnDefinition(key, header, width, ColumnType.DATETIME);
    }
}
