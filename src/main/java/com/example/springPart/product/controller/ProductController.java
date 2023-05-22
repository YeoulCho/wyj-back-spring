package com.example.springPart.product.controller;

import com.example.springPart.product.controller.form.ProductRegistRequestForm;
import com.example.springPart.product.entity.Product;
import com.example.springPart.product.repository.ProductRepository;
import com.example.springPart.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    final ProductService productService;

    @PostMapping("/regist")
    public Product regist(ProductRegistRequestForm requestFom) {
        return productService.regist(requestFom);
    }
}
