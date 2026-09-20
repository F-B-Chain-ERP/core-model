package com.erp.core.dto.response.inv;

import java.math.BigDecimal;
import java.time.Instant;

/** Một chiều quy đổi đơn vị kèm tên/mã 2 đầu để hiển thị. */
public record UnitConversionResponse(

        String id,

        String fromUnitId,

        String fromUnitCode,

        String fromUnitName,

        String toUnitId,

        String toUnitCode,

        String toUnitName,

        BigDecimal factor,

        String status,

        Instant createdAt
) {
}
