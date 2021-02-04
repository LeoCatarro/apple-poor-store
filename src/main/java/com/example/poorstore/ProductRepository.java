package com.example.poorstore;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByCategory(String category);

    Product findById(long id);

    List<Product> findByProductName(String productName);
}
