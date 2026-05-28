package org.sam.ecommerce.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.sam.ecommerce.dto.projection.ProductSummaryProjection;
import org.sam.ecommerce.dto.request.ProductCreationRequest;
import org.sam.ecommerce.dto.request.ProductVariantCreationRequest;
import org.sam.ecommerce.dto.response.ProductResponse;
import org.sam.ecommerce.entity.Category;
import org.sam.ecommerce.entity.Image;
import org.sam.ecommerce.entity.Product;
import org.sam.ecommerce.entity.ProductVariant;
import org.sam.ecommerce.mapper.ProductMapper;
import org.sam.ecommerce.mapper.ProductVariantMapper;
import org.sam.ecommerce.repository.ProductRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {
    ProductMapper mapper;
    ImageService imageService;
    EntityManager entityManager;
    ProductRepository repository;
    CategoryService categoryService;
    ProductVariantMapper variantMapper;

    @Transactional
    public ProductResponse create(ProductCreationRequest request) {
        if (!categoryService.existsById(request.categoryId())) {
            throw new IllegalArgumentException("Category not found.");
        }

        if (!imageService.existsById(request.imageId())) {
            throw new IllegalArgumentException("Image not found.");
        }

        Product product = mapper.toEntity(request);

        // Set category
        Category category = entityManager.getReference(Category.class, request.categoryId());
        product.setCategory(category);

        // Set image
        Image image = entityManager.getReference(Image.class, request.imageId());
        product.setImage(image);

        Set<ProductVariant> variants = mapVariants(request.variants(), product);
        product.setProductVariants(variants);

        Product savedProduct = repository.saveAndFlush(product);
        return mapper.toDto(savedProduct);
    }

    private Set<ProductVariant> mapVariants(Collection<ProductVariantCreationRequest> requests, Product product) {
        if (requests == null || requests.isEmpty()) return Set.of();
        Set<Long> imageIds = requests.stream().map(ProductVariantCreationRequest::imageId).filter(Objects::nonNull).collect(Collectors.toSet());
        Set<Long> existingIds = imageService.findExistingIdsIn(imageIds);
        imageIds.removeAll(existingIds);
        if (!imageIds.isEmpty()) throw new IllegalArgumentException("Image not found: " + imageIds);
        return requests.stream().map(req -> {
                ProductVariant variant = variantMapper.toEntity(req);
                variant.setProduct(product);
                if (req.imageId() != null) {
                    Image varImage = entityManager.getReference(Image.class, req.imageId());
                    variant.setImage(varImage);
                }
                return variant;
            }
        ).collect(Collectors.toSet());
    }

    public Slice<ProductSummaryProjection> getProducts(Pageable pageable) {
        return repository.findAllBy(pageable);
    }
}