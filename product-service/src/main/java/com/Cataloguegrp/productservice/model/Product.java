package com.Cataloguegrp.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Products")
@Data
public class Product {

    @Id

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long Id;
    private String name;
    private String description;
    private BigDecimal price;
}
