package org.sam.ecommerce.dto.request;

import java.math.BigDecimal;

public record ProductVariantCreationRequest(
    Long id,
    BigDecimal price,
    Integer stock,
    String sku,
    Long imageId,
    String option1,
    String option2,
    String option3
) {}
