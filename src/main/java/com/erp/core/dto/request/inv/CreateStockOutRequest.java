package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Yêu cầu tạo mới phiếu xuất kho. Mã phiếu (code) và trạng thái do hệ thống quản lý:
 * sinh tự động theo định dạng {@code SO-yyyyMM-XXXX} và ghi sổ theo vòng đời DRAFT -&gt; POSTED/CANCELLED.
 */
public record CreateStockOutRequest(
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