package org.sam.ecommerce.dto.request;

import java.util.Set;

public record ProductCreationRequest(
    String name,
    String description,
    Long categoryId,
    Long imageId,
    String option1Name,
    String option2Name,
    String option3Name,
    Set<ProductVariantCreationRequest> variants
) {
}
