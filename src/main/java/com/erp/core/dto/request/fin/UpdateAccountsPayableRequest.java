package com.erp.core.dto.request.fin;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO yêu cầu cập nhật công nợ phải trả.
 * Chỉ cho phép cập nhật khi công nợ ở trạng thái UNPAID chưa có hóa đơn và chưa có thanh toán.
 */
public record UpdateAccountsPayableRequest(

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
