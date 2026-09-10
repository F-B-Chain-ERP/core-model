package com.erp.core.dto.request.menu;

import java.util.List;

/**
 * DTO yêu cầu bulk-replace toàn bộ BOM của một_variant.
 * Danh sách {@code items} rỗng ({@code []}) hợp lệ — nghĩa là xóa toàn bộ BOM.
 * {@code items = null} không hợp lệ.
 */
public record UpdateBomRequest(
        List<CreateBomItemRequest> items
) {
}
