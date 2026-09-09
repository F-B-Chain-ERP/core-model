package com.erp.core.dto.response.menu;

import java.math.BigDecimal;

/**
 * Phản hồi tóm tắt sau khi tạo sản phẩm mới thành công (HTTP 201).
 *
 * @param id        ID sản phẩm vừa được tạo
 * @param code      Mã sản phẩm
 * @param name      Tên sản phẩm
 * @param basePrice Đơn giá cơ bản
 * @param status    Trạng thái (mặc định "ACTIVE")
 */
public record CreateProductResponse(
        String id,
        String code,
        String name,
        BigDecimal basePrice,
        String status
) {
}
