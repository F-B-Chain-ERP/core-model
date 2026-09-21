package com.erp.core.dto.response.pos;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Một dòng tồn mở bán trong ngày kèm tên SP/biến thể để màn Tồn sản phẩm hiển thị.
 */
public record DailyStockLineResponse(
    UUID variantId,
    String variantCode,
    String variantName,
    UUID productId,
    String productCode,
    String productName,
    LocalDate businessDate,
    Integer openingQuantity,
    Integer soldQuantity,
    Integer remainingQuantity
) {}
