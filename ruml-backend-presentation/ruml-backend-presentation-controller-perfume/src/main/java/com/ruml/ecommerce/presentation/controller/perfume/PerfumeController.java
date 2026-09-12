package com.ruml.ecommerce.presentation.controller.perfume;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import com.ruml.ecommerce.core.perfume.factory.request.GetPerfumeDetailsRequest;
import com.ruml.ecommerce.core.perfume.factory.request.ListPerfumesRequest;
import com.ruml.ecommerce.core.perfume.factory.response.GetPerfumeDetailsResponse;
import com.ruml.ecommerce.core.perfume.factory.response.ListPerfumesResponse;
import com.ruml.ecommerce.core.perfume.usecase.GetPerfumeDetailsQuery;
import com.ruml.ecommerce.core.perfume.usecase.ListPerfumesQuery;
import com.ruml.ecommerce.core.shared.entity.pagination.PageQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Tag(name = "Perfume", description = "Perfume management API")
@RequestMapping("/api/perfumes")
public class PerfumeController {

    private final ListPerfumesQuery listPerfumesQuery;
    private final GetPerfumeDetailsQuery getPerfumeDetailsQuery;

    public PerfumeController(ListPerfumesQuery listPerfumesQuery, GetPerfumeDetailsQuery getPerfumeDetailsQuery) {
        this.listPerfumesQuery = listPerfumesQuery;
        this.getPerfumeDetailsQuery = getPerfumeDetailsQuery;
    }

    @GetMapping
    @Operation(summary = "List all perfumes (Paginated)")
    public ResponseEntity<ListPerfumesResponse> listPerfumes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "DESC") String sortDirection) {
        
        PageQuery query = new PageQuery(page, size, sortBy, sortDirection);
        ListPerfumesResponse response = listPerfumesQuery.execute(new ListPerfumesRequest(query));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get perfume details")
    public ResponseEntity<GetPerfumeDetailsResponse> getPerfume(@PathVariable String id) {
        GetPerfumeDetailsResponse response = getPerfumeDetailsQuery.execute(new GetPerfumeDetailsRequest(id));
        return ResponseEntity.ok(response);
    }
}
