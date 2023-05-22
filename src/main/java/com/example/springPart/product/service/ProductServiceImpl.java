package com.example.springPart.product.service;

import com.example.springPart.product.controller.form.ProductRegistRequestForm;
import com.example.springPart.product.entity.Product;
import com.example.springPart.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    final ProductRepository productRepository;
    @Override
    public Product regist(ProductRegistRequestForm requestFom) {
        Product product = requestFom.toProduct();
        Optional<Product> maybeProduct = productRepository.findByProductName(product.getProductName());
        if(maybeProduct.isPresent()) {
            return null;
        }
        return productRepository.save(product);
    }
}
