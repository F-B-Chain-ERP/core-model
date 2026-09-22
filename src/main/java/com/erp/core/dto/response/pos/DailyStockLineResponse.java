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
    Integer remainingQuantity,
    /**
     * Số ly tối đa pha được từ tồn NVL kho quán (min theo BOM, quy đơn vị gốc).
     * null = chưa có công thức hoặc chưa xác định được kho (xem hasRecipe).
     */
    Integer capabilityQuantity,
    /** false = biến thể chưa có dòng BOM ACTIVE nào. */
    boolean hasRecipe
) {}
