package org.sam.ecommerce.dto.response;

public record CategoryResponse(
    Long id,
    String name,
    String slug
) {}
