package org.sam.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.sam.ecommerce.dto.request.ProductCreationRequest;
import org.sam.ecommerce.dto.response.ProductResponse;
import org.sam.ecommerce.dto.response.ProductVariantResponse;
import org.sam.ecommerce.entity.Product;
import org.sam.ecommerce.entity.ProductVariant;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    Product toEntity(ProductCreationRequest request);

    @Mapping(target = "variants", source = "productVariants")
    ProductResponse toDto(Product product);

    ProductVariantResponse toResponse(ProductVariant productVariant);
}
