package com.example.springPart.product.controller.form;

import com.example.springPart.product.entity.Product;
import com.example.springPart.product.entity.ProductCategory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductRegistRequestForm {
    final private String productName;
    final private Integer productPrice;
    final private String imagePath;
    final private Integer discountPercent;
    final private ProductCategory productCategory;

    public Product toProduct() {
        return new Product(productName, productPrice, imagePath, discountPercent, productCategory);
    }
}
