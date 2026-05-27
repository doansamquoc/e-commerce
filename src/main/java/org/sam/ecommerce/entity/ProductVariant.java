package org.sam.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_variants")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariant extends Base {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    Product product;

    String name;
    BigDecimal price;
    String option1;
    String option2;
    String option3;
}
