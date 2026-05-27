package org.sam.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.sam.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment extends Base {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    Customer customer;

    PaymentMethod paymentMethod;
    String code;
    String vat;
    BigDecimal total;
}
