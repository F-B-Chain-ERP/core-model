package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.NotNull;

/**
 * Duyệt yêu cầu điều chuyển (nhị phân): duyệt để đi tiếp, hoặc từ chối kèm lý do.
 * Người duyệt (phe kho) được trùng người xuất, nhưng phải khác người tạo yêu cầu (phe quán).
 */
public record ApproveStockTransferRequest(

        @NotNull(message = "Vui lòng chọn duyệt hoặc từ chối")
        Boolean approved,

        /** Bắt buộc khi từ chối. */
        String reason
) {
}
