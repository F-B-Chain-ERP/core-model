package com.erp.core.dto.request.pos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

/** Chốt tồn mở bán hàng loạt: 1 lệnh cho nhiều size, lỗi dòng nào giữ dòng đó. */
public record RestockDailyStockBatchRequest(

        @NotNull(message = "Chi nhánh không được để trống")
        UUID branchId,

        String note,

        @NotEmpty(message = "Phải có ít nhất một dòng chốt tồn")
        List<@Valid RestockDailyStockBatchItemRequest> items
) {
    public record RestockDailyStockBatchItemRequest(

            @NotNull(message = "Biến thể không được để trống")
            UUID variantId,

            @NotNull(message = "Số lượng không được để trống")
            @Min(value = 0, message = "Số lượng tồn mở bán phải >= 0")
            Integer openingQuantity
    ) {
    }
}
