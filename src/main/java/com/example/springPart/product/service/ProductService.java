package com.example.springPart.product.service;

import com.example.springPart.product.controller.form.ProductRegistRequestForm;
import com.example.springPart.product.entity.Product;

public interface ProductService {
    Product regist(ProductRegistRequestForm requestFom);
}
