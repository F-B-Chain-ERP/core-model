package com.erp.core.dto.request.menu;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record BulkSyncComboItemsRequest(

        @NotEmpty(message = "Danh sách thành phần Combo không được để trống")
        @Valid
        List<SyncComboItemEntry> items
) {
    public record SyncComboItemEntry(

            @NotNull(message = "Biến thể không được để trống")
            UUID variantId,

            @NotNull(message = "Số lượng không được để trống")
            @Min(value = 1, message = "Số lượng phải >= 1")
            Integer quantity,

            Boolean isSubstitutable
    ) {
        public SyncComboItemEntry {
            if (isSubstitutable == null) isSubstitutable = false;
            if (quantity == null) quantity = 1;
        }
    }
}
