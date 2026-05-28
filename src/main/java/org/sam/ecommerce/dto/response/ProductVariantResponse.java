package org.sam.ecommerce.dto.response;

import java.math.BigDecimal;

public record ProductVariantResponse(
    Long id,
    String name,
    BigDecimal price,
    Integer stock,
    String sku,
    ImageResponse image,
    String option1,
    String option2,
    String option3
) {}
