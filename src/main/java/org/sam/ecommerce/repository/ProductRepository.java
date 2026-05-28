package org.sam.ecommerce.repository;

import org.sam.ecommerce.dto.projection.ProductSummaryProjection;
import org.sam.ecommerce.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Slice<ProductSummaryProjection> findAllBy(Pageable pageable);
}
