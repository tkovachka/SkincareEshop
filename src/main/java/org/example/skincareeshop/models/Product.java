package org.example.skincareeshop.models;

import jakarta.persistence.*;
import lombok.Data;
import org.example.skincareeshop.models.enums.PRODUCT_TYPE;
import org.example.skincareeshop.models.enums.SKIN_TYPE;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    @Column(length = 10_000)
    private String description;
    private Integer price;
    @Enumerated(EnumType.STRING)
    private PRODUCT_TYPE productType;
    @Enumerated(EnumType.STRING)
    private SKIN_TYPE skinType;
    private Integer stockQuantity;
    @Column(length = 10_000)
    private String ingredients;

}
