package com.erp.core.dto.response.pos;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Một dòng NVL trong ngày: kế hoạch (mở bán × BOM) vs đã dùng (đã bán × BOM)
 * vs tồn kho bar, suy ra số thiếu để xin cấp từ kho tổng.
 * Mọi số lượng đã quy về đơn vị gốc của NVL; unitMismatch = có dòng BOM
 * không quy đổi được (cộng thô, cần đối chiếu tay).
 */
public record MaterialShortageLineResponse(
    UUID materialId,
    String materialCode,
    String materialName,
    String baseUnitCode,
    BigDecimal plannedQuantity,
    BigDecimal consumedQuantity,
    BigDecimal onHandQuantity,
    BigDecimal shortageQuantity,
    boolean unitMismatch
) {}
