package org.sam.ecommerce.dto.response;

import java.util.Map;
import java.util.Set;

public record ProductResponse(
    Long id,
    String name,
    String description,
    String slug,
    ImageResponse image,
    CategoryResponse category,
    Map<String, Object> attributes,
    Set<ProductVariantResponse> variants
) {}
