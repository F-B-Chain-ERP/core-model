package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateMaterialRequest(

        @NotBlank(message = "Mã nguyên vật liệu không được để trống")
        @Size(max = 50, message = "Mã nguyên vật liệu tối đa 50 ký tự")
        @Pattern(
                regexp = "^[A-Z0-9_-]+$",
                message = "Mã nguyên vật liệu chỉ gồm chữ hoa, số, dấu gạch ngang hoặc gạch dưới"
        )

        String code,

        @NotBlank(message = "Tên nguyên vật liệu không được để trống")
        @Size(max = 150, message = "Tên nguyên vật liệu tối đa 150 ký tự")
        String name,

        @NotNull(message = "Danh mục không được để trống")
        UUID categoryId,

        @NotNull(message = "Đơn vị tính cơ sở không được để trống")
        UUID baseUnitId,

        @DecimalMin(value = "0.0", inclusive = true, message = "Ngưỡng tồn tối thiểu phải lớn hơn hoặc bằng 0")
        BigDecimal minStockAlert,

        @Min(value = 1, message = "Số ngày sử dụng phải lớn hơn 0")
        Integer shelfLifeDays,

        Boolean isPerishable
) {
}
