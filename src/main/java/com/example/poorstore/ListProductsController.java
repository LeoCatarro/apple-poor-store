package com.example.poorstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListProductsController {

    private static final Logger log = LoggerFactory.getLogger(ListProductsController.class);

    @Autowired
    private ProductRepository repository;

    @GetMapping("/list-products")
    public String listClients(Model model)
    {
        List<Product> productList = (List<Product>) repository.findAll();

        log.info("Products found with findAll():");
        log.info("-------------------------------");
        for (Product product : repository.findAll()) {
            log.info(product.toString());
        }
        log.info("");

        model.addAttribute("productList", productList);
        return "list-products-view";
    }
}
