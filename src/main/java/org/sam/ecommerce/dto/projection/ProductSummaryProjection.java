package org.sam.ecommerce.dto.projection;


public interface ProductSummaryProjection {
    Long getId();

    String getName();

    String getSlug();

    ImageProjection getImage();
}
