package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * Yêu cầu chuyển trạng thái phiếu nhập/xuất kho (POSTED hoặc CANCELLED).
 */
public record StatusUpdateRequest(
        @NotBlank(message = "Trạng thái không được để trống")
        @Pattern(regexp = "POSTED|CANCELLED", message = "Trạng thái chỉ nhận giá trị POSTED hoặc CANCELLED")
        String status
) {
}