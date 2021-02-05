package com.example.poorstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NewProductController {

    private static final Logger log = LoggerFactory.getLogger(NewProductController.class);

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/new-product")
    public String newProduct(
            @RequestParam(name="productName", required=false, defaultValue="World") String productName,
            @RequestParam(name="price", required=false, defaultValue="") Integer price,
            @RequestParam(name="quantity", required=false, defaultValue="") Integer quantity,
            @RequestParam(name="description", required=false, defaultValue="") String description,
            @RequestParam(name="category", required=false, defaultValue="") String category,
            @RequestParam(name="imgUrl", required=false, defaultValue="") String imgUrl,
            Model model)
    {

        productRepository.save(new Product(productName, description, price, quantity, category, imgUrl));

        log.info("Products found with findAll():");
        log.info("-------------------------------");
        for (Product aProduct : productRepository.findAll()) {
            log.info(aProduct.toString());
        }
        log.info("");

        model.addAttribute("productName", productName);
        model.addAttribute("description", description);
        model.addAttribute("price", price);
        model.addAttribute("quantity", quantity);
        model.addAttribute("category", category);
        model.addAttribute("imgUrl", imgUrl);

        return "new-product-view";
    }
}