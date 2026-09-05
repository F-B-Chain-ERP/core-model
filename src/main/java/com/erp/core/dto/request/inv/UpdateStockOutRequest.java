package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Yêu cầu cập nhật phiếu xuất kho (chỉ áp dụng khi phiếu còn DRAFT). Cấu trúc và ràng buộc
 * giống API tạo; mã phiếu (code) do hệ thống quản lý nên không nằm trong request.
 */
public record UpdateStockOutRequest(
        @NotNull(message = "Kho không được để trống")
        UUID warehouseId,

        @NotNull(message = "Loại đích xuất không được để trống")
        String destinationType,

        UUID destinationReferenceId,

        @NotNull(message = "Ngày xuất không được để trống")
        LocalDate outDate,

        String note,

        @NotEmpty(message = "Phiếu xuất phải có ít nhất một dòng chi tiết")
        List<StockOutItemRequest> items
) {
}