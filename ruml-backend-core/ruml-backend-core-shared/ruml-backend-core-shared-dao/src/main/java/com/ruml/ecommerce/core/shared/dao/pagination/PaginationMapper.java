package com.ruml.ecommerce.core.shared.dao.pagination;

import com.ruml.ecommerce.core.shared.entity.pagination.PageQuery;
import com.ruml.ecommerce.core.shared.entity.pagination.PageResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PaginationMapper {

    private PaginationMapper() {}

    public static Pageable toPageable(PageQuery query) {
        if (query == null) {
            return Pageable.unpaged();
        }
        return PageRequest.of(query.page(), query.size());
    }

    public static <T> PageResult<T> toPageResult(Page<T> page) {
        return new PageResult<>(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast()
        );
    }

    public static <T, R> PageResult<R> toPageResult(Page<T> page, Function<T, R> mapper) {
        List<R> mappedContent = page.getContent().stream()
                .map(mapper)
                .collect(Collectors.toList());

        return new PageResult<>(
                mappedContent,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast()
        );
    }
}
