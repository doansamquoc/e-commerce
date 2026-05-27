package org.sam.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shipments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Shipment extends Base {
    String fullName;
    String contact;
    String code;
    String phoneNumber;
    String address;
    String city;
    String carrierName;
}
