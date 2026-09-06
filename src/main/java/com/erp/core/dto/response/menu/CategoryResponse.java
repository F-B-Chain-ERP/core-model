package com.erp.core.dto.response.menu;

import java.time.Instant;

/**
 * DTO phía response biểu diễn một danh mục (master dùng chung INV + MENU).
 */
public record CategoryResponse(

        /** ID danh mục (UUID dạng chuỗi). */
        String id,

        /** Loại danh mục (PRODUCT/MATERIAL). */
        String categoryType,

        /** Mã danh mục (duy nhất trong loại). */
        String code,

        /** Tên danh mục. */
        String name,

        /** Mô tả danh mục. */
        String description,

        /** Đường dẫn ảnh tab menu. */
        String imageUrl,

        /** Thứ tự hiển thị. */
        Integer displayOrder,

        /** Trạng thái bản ghi (ACTIVE/INACTIVE). */
        String status,

        /** Số món bán + nguyên vật liệu đang dùng danh mục này. */
        long usedCount,

        /** Người tạo bản ghi. */
        String createdBy,

        /** Thời điểm tạo. */
        Instant createdAt,

        /** Người cập nhật gần nhất. */
        String updatedBy,

        /** Thời điểm cập nhật gần nhất. */
        Instant updatedAt
) {
}
