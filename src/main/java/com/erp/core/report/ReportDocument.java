package com.erp.core.report;

import com.erp.core.enums.ReportType;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Hợp đồng tài liệu báo cáo đa phân đoạn (Multi-Section Report Document).
 * Cho phép biểu diễn linh hoạt các báo cáo phức tạp (Header, KeyValue, Bảng chính,
 * Bảng phụ mệnh giá, Ghi chú, Khung chữ ký).
 */
public record ReportDocument(
        ReportType reportType,
        String schemaVersion,
        String locale,
        String timezone,
        ReportHeader header,
        List<ReportSection> sections,
        OutputOptions outputOptions
) {
    public ReportDocument {
        schemaVersion = (schemaVersion != null && !schemaVersion.isBlank()) ? schemaVersion : "1.0";
        locale = (locale != null && !locale.isBlank()) ? locale : "vi-VN";
        timezone = (timezone != null && !timezone.isBlank()) ? timezone : "Asia/Ho_Chi_Minh";
        sections = sections != null ? List.copyOf(sections) : Collections.emptyList();
        outputOptions = outputOptions != null ? outputOptions : OutputOptions.defaultLandscape();
    }

    public record ReportHeader(
            String title,
            String subtitle,
            String logoPath,
            Map<String, Object> metadata
    ) {
        public ReportHeader {
            metadata = metadata != null ? Map.copyOf(metadata) : Collections.emptyMap();
        }
    }

    public sealed interface ReportSection permits TableSection, KeyValueSection, SignatureSection, NoteSection {
        String label();
    }

    public record TableSection(
            String label,
            List<ReportColumnDefinition> columns,
            List<Map<String, Object>> rows,
            Map<String, Object> summary
    ) implements ReportSection {
        public TableSection {
            columns = columns != null ? List.copyOf(columns) : Collections.emptyList();
            rows = rows != null ? List.copyOf(rows) : Collections.emptyList();
            summary = summary != null ? Map.copyOf(summary) : Collections.emptyMap();
        }
    }

    public record KeyValueSection(
            String label,
            Map<String, Object> entries
    ) implements ReportSection {
        public KeyValueSection {
            entries = entries != null ? Map.copyOf(entries) : Collections.emptyMap();
        }
    }

    public record SignatureSection(
            String label,
            List<String> signerLabels
    ) implements ReportSection {
        public SignatureSection {
            signerLabels = signerLabels != null ? List.copyOf(signerLabels) : Collections.emptyList();
        }
    }

    public record NoteSection(
            String label,
            String content
    ) implements ReportSection {
    }

    public enum PageOrientation {
        PORTRAIT,
        LANDSCAPE
    }

    public record OutputOptions(
            PageOrientation orientation,
            List<String> sheetNames,
            boolean repeatHeaders,
            boolean pageNumbers
    ) {
        public OutputOptions {
            orientation = orientation != null ? orientation : PageOrientation.LANDSCAPE;
            sheetNames = sheetNames != null ? List.copyOf(sheetNames) : Collections.emptyList();
        }

        public static OutputOptions defaultLandscape() {
            return new OutputOptions(PageOrientation.LANDSCAPE, List.of(), true, true);
        }

        public static OutputOptions defaultPortrait() {
            return new OutputOptions(PageOrientation.PORTRAIT, List.of(), true, true);
        }
    }
}
