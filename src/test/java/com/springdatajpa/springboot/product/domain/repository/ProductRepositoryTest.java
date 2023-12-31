package com.springdatajpa.springboot.product.domain.repository;

import com.springdatajpa.springboot.product.domain.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // create product object
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABCD");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        // save product object
        Product saveObject = productRepository.save(product);

        // display product info
        System.out.println(saveObject.getId());
        System.out.println(saveObject.toString());
    }

    @Test
    void updateUsingSaveMethod() {
        // find or read product object
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        // update product object
        product.setName("product 1 updated");
        product.setDescription("product 1 description updated");

        // save updated product object
        Product updatedProduct = productRepository.save(product);

        // display product info
        System.out.println(updatedProduct.getId());
        System.out.println(updatedProduct.toString());
    }
}