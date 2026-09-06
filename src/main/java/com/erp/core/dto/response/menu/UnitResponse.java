package com.erp.core.dto.response.menu;

import java.time.Instant;

/**
 * DTO phía response biểu diễn một đơn vị tính (master data dùng chung INV + MENU).
 */
public record UnitResponse(

        /** ID đơn vị tính (UUID dạng chuỗi). */
        String id,

        /** Mã đơn vị tính (duy nhất). */
        String code,

        /** Tên đơn vị tính. */
        String name,

        /** Nhóm đơn vị tính (COUNT/WEIGHT/VOLUME). */
        String unitType,

        /** Trạng thái bản ghi (ACTIVE/INACTIVE). */
        String status,

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
