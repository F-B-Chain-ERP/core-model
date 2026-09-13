package com.erp.core.dto.request.menu;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CalculateComboPriceRequest(

        @NotNull(message = "ID Combo không được để trống")
        UUID comboProductId,

        @NotNull(message = "Giá gốc combo không được để trống")
        @DecimalMin(value = "0", message = "Giá gốc combo phải >= 0")
        BigDecimal originalComboPrice,

        @NotEmpty(message = "Danh sách thành phần không được để trống")
        @Valid
        List<ComboItemSwap> items
) {
    public record ComboItemSwap(

            @NotNull(message = "ID combo item không được để trống")
            UUID originalComboItemId,

            @NotNull(message = "ID biến thể mới không được để trống")
            UUID newVariantId,

            @NotNull(message = "Số lượng không được để trống")
            @Min(value = 1, message = "Số lượng phải >= 1")
            Integer quantity
    ) {
        public ComboItemSwap {
            if (quantity == null) quantity = 1;
        }
    }
}
