package com.example.poorstore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String productName,description;

    @Column
    private Integer price, quantity;

    public Product() {}

    public Product(String productName, String description, Integer price, Integer quantity) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format(
                "Product[id=%d, productName='%s', price='%d', quantity='%d', description='%s']",
                id, productName, price, quantity, description);
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
