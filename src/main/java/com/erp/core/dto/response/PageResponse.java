package com.erp.core.dto.response;

import java.util.List;

/**
 * Standard wrapper for paginated response data.
 */
public record PageResponse<T>(
        int pageNumber,
        int pageSize,
        long totalElements,
        int totalPages,
        List<T> content
) {
}
