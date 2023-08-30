package com.springdatajpa.springboot.product.domain.repository;

import com.springdatajpa.springboot.product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
