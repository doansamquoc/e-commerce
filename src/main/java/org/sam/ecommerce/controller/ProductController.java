package org.sam.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.sam.ecommerce.dto.projection.ProductSummaryProjection;
import org.sam.ecommerce.dto.request.ProductCreationRequest;
import org.sam.ecommerce.dto.response.ProductResponse;
import org.sam.ecommerce.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponse create(@Valid @RequestBody ProductCreationRequest request) {
        return service.create(request);
    }

    @GetMapping
    Slice<ProductSummaryProjection> getProducts(@PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return service.getProducts(pageable);
    }
}
