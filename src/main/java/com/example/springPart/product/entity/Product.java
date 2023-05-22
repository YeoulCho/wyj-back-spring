package com.example.springPart.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String productName;
    private Integer productPrice;
    private String imagePath;
    private Integer discountPercent;
    @Enumerated
    private ProductCategory productCategory;

    public Product(String productName, Integer productPrice, String imagePath, Integer discountPercent, ProductCategory productCategory) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.imagePath = imagePath;
        this.discountPercent = discountPercent;
        this.productCategory = productCategory;
    }

}
