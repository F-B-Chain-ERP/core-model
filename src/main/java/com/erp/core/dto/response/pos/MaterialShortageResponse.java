package com.erp.core.dto.response.pos;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/** Bảng đối soát NVL ngày của 1 chi nhánh: cần/đã dùng/tồn/thiếu + kho 2 đầu. */
public record MaterialShortageResponse(
    UUID branchId,
    LocalDate businessDate,
    UUID warehouseId,
    String warehouseCode,
    UUID centralWarehouseId,
    String centralWarehouseCode,
    List<MaterialShortageLineResponse> lines
) {}
