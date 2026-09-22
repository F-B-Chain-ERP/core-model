package com.erp.core.dto.response.pos;

import java.util.List;
import java.util.UUID;

/** Kết quả chốt tồn hàng loạt: từng dòng ok/lỗi riêng, không rollback cả lô. */
public record DailyStockBatchResponse(
    int succeeded,
    int failed,
    List<DailyStockBatchItemResponse> items
) {
    public record DailyStockBatchItemResponse(
        UUID variantId,
        boolean ok,
        String message,
        Integer openingQuantity,
        Integer remainingQuantity
    ) {
    }
}
