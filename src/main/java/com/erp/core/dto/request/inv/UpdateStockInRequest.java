package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Yêu cầu cập nhật phiếu nhập kho (chỉ áp dụng khi phiếu còn DRAFT). Cấu trúc và ràng buộc
 * giống API tạo; mã phiếu (code) do hệ thống quản lý nên không nằm trong request.
 */
public record UpdateStockInRequest(
        @NotNull(message = "Kho không được để trống")
        UUID warehouseId,

        @NotNull(message = "Nguồn nhập không được để trống")
        String sourceType,

        UUID sourceReferenceId,

        @NotNull(message = "Ngày nhập không được để trống")
        LocalDate inDate,

        String note,

        @NotEmpty(message = "Phiếu nhập phải có ít nhất một dòng chi tiết")
        List<StockInItemRequest> items
) {
}