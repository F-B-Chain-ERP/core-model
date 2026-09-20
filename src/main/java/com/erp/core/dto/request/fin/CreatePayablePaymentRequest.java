package com.erp.core.dto.request.fin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO yêu cầu ghi nhận thanh toán công nợ (Accounts Payable Payment).
 */
public record CreatePayablePaymentRequest(

        @NotNull(message = "Ngày thanh toán không được để trống")
        LocalDate paymentDate,

        @NotNull(message = "Số tiền thanh toán không được để trống")
        @Positive(message = "Số tiền thanh toán phải lớn hơn 0")
        BigDecimal amount,

        @NotBlank(message = "Phương thức thanh toán không được để trống")
        @Size(max = 50, message = "Phương thức thanh toán tối đa 50 ký tự")
        String paymentMethod,

        @Size(max = 100, message = "Mã tham chiếu tối đa 100 ký tự")
        String referenceNo
) {
}
