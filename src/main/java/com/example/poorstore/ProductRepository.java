package com.example.poorstore;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findByCategory(String category);

    List<Product> findAllByCategory(String category);

    Product findById(long id);

    Product findByProductName(String productName);

}
