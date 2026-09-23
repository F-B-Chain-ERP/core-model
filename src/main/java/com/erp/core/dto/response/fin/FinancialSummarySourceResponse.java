package com.erp.core.dto.response.fin;

import com.erp.core.dto.response.PageResponse;

import java.util.List;

/**
 * Dữ liệu nguồn đối soát của một báo cáo tài chính (ORDERS | REFUNDS | EXPENSES) kèm phân trang.
 *
 * @param <T> Loại dòng dữ liệu nguồn theo {@code source}.
 */
public record FinancialSummarySourceResponse<T>(
        String source,
        int pageNumber,
        int pageSize,
        long totalElements,
        int totalPages,
        List<T> items
) {

    public static <T> FinancialSummarySourceResponse<T> of(String source, PageResponse<T> page) {
        return new FinancialSummarySourceResponse<>(
                source,
                page.pageNumber(),
                page.pageSize(),
                page.totalElements(),
                page.totalPages(),
                page.content()
        );
    }
}