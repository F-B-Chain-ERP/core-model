package com.erp.core.dto.request.fin;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO yêu cầu tạo mới công nợ phải trả (Accounts Payable).
 * Dùng cho cả tạo thủ công và tạo tự động từ PO.
 */
public record CreateAccountsPayableRequest(

        @NotNull(message = "Nhà cung cấp không được để trống")
        UUID supplierId,

        UUID purchaseOrderId,

        @Size(max = 100, message = "Số hóa đơn tối đa 100 ký tự")
        String invoiceNo,

        @NotNull(message = "Số tiền hóa đơn không được để trống")
        @PositiveOrZero(message = "Số tiền hóa đơn phải lớn hơn hoặc bằng 0")
        BigDecimal invoiceAmount,

        LocalDate dueDate,

        @Size(max = 500, message = "Ghi chú tối đa 500 ký tự")
        String note
) {
}
