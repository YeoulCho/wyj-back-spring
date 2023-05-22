package com.example.springPart.product;

import com.example.springPart.product.controller.form.ProductRegistRequestForm;
import com.example.springPart.product.entity.Product;
import com.example.springPart.product.entity.ProductCategory;
import com.example.springPart.product.repository.ProductRepository;
import com.example.springPart.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.springPart.product.entity.ProductCategory.OUTER;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductRegistTest {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("사업자회원이 물건을 등록합니다")
    public void business_member_product_registration() {
        String productName = "testProduct1";
        Integer productPrice = 1000;
        String imagePath = "xxx";
        Integer discountPercent = 0;
        ProductCategory productCategory = OUTER;

        ProductRegistRequestForm requestFom = new ProductRegistRequestForm(
                productName, productPrice, imagePath, discountPercent, productCategory);
        Product registeredProduct = productService.regist(requestFom);

        assertEquals(productName, registeredProduct.getProductName());
    }
}