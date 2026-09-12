package com.ruml.ecommerce.core.shared.entity.pagination;

import java.util.List;

public record PageResult<T>(
    List<T> content,
    int pageNumber,
    int pageSize,
    long totalElements,
    int totalPages,
    boolean isFirst,
    boolean isLast
) {
    public static <T> PageResult<T> empty() {
        return new PageResult<>(List.of(), 0, 0, 0, 0, true, true);
    }
}
