package org.sam.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.sam.ecommerce.dto.request.ProductVariantCreationRequest;
import org.sam.ecommerce.dto.response.ProductVariantResponse;
import org.sam.ecommerce.entity.ProductVariant;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductVariantMapper {
    ProductVariant toEntity(ProductVariantCreationRequest request);

    ProductVariantCreationRequest toDto(ProductVariant variant);

    ProductVariantResponse toResponse(ProductVariant variant);
}
