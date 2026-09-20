package com.erp.core.util;

import com.erp.core.constants.ReportExportConstants;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Bộ giải quyết đường dẫn logo báo cáo — thống nhất thứ tự ưu tiên chung cho cả
 * backend-service và queue-service:
 *
 * <ol>
 *   <li>Logo truyền theo từng báo cáo qua {@code ReportDataContext.logoPath}.</li>
 *   <li>Logo cấu hình hệ thống {@code app.report.logo-path}.</li>
 *   <li>Logo mặc định {@code ReportExportConstants.DEFAULT_LOGO_PATH}.</li>
 *   <li>Logo placeholder đóng gói sẵn trong classpath {@code /report/logo-erp.png}.</li>
 * </ol>
 *
 * <p>Nhờ tầng fallback cuối, báo cáo không bao giờ bị mất logo đột ngột khi file
 * logo ngoài hệ thống chưa được đặt lên máy.</p>
 */
public final class ReportLogoResolver {

    /** Đường dẫn classpath tới logo placeholder đóng gói trong JAR. */
    public static final String BUNDLED_LOGO = "/report/logo-erp.png";

    private ReportLogoResolver() {
    }

    /**
     * Nạp logo theo thứ tự ưu tiên mô tả ở trên.
     *
     * @param configuredLogoPath giá trị {@code app.report.logo-path} (có thể rỗng/null)
     * @param contextLogoPath    logo truyền theo từng báo cáo (có thể rỗng/null)
     * @return mảng byte ảnh logo, hoặc {@code null} nếu tất cả nguồn đều không có
     */
    public static byte[] resolve(String configuredLogoPath, String contextLogoPath) {
        byte[] contextLogo = loadFile(contextLogoPath);
        if (contextLogo != null) {
            return contextLogo;
        }
        byte[] configLogo = loadFile(configuredLogoPath);
        if (configLogo != null) {
            return configLogo;
        }
        byte[] defaultLogo = loadFile(ReportExportConstants.DEFAULT_LOGO_PATH);
        if (defaultLogo != null) {
            return defaultLogo;
        }
        return loadClasspathBundled();
    }

    /** Đọc logo placeholder đóng gói trong classpath. */
    public static byte[] loadClasspathBundled() {
        try (InputStream in = ReportLogoResolver.class.getResourceAsStream(BUNDLED_LOGO)) {
            if (in == null) {
                return null;
            }
            return in.readAllBytes();
        } catch (IOException e) {
            return null;
        }
    }

    private static byte[] loadFile(String path) {
        if (path == null || path.isBlank()) {
            return null;
        }
        try {
            Path resolved = Path.of(path);
            if (Files.exists(resolved) && Files.isRegularFile(resolved)) {
                return Files.readAllBytes(resolved);
            }
        } catch (Exception ignored) {
            // Logo là tuỳ chọn — thiếu/không đọc được thì chuyển nguồn kế tiếp.
        }
        return null;
    }
}