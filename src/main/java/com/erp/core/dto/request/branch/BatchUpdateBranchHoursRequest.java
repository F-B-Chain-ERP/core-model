package com.erp.core.dto.request.branch;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * DTO cập nhật hàng loạt lịch tuần (Batch Update) cho chi nhánh.
 */
public record BatchUpdateBranchHoursRequest(
        @NotEmpty(message = "Danh sách lịch giờ không được rỗng")
        @Valid
        List<UpdateBranchHoursItemRequest> hours
) {
}
