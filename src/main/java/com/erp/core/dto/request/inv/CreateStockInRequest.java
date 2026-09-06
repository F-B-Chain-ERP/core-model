package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Yêu cầu tạo mới phiếu nhập kho. Mã phiếu (code) và trạng thái do hệ thống quản lý:
 * sinh tự động theo định dạng {@code SI-yyyyMM-XXXX} và ghi sổ theo vòng đời DRAFT -&gt; POSTED/CANCELLED.
 */
public record CreateStockInRequest(
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