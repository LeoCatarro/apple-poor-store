package com.example.poorstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListProductsController {

    private static final Logger log = LoggerFactory.getLogger(ListProductsController.class);

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/homepage")
    public String listProducts(Model model)
    {
        List<Product> productList = (List<Product>) productRepository.findAll();

        log.info("Products found with findAll():");
        log.info("-------------------------------");
        for (Product product : productRepository.findAll()) {
            log.info(product.toString());
        }
        log.info("");

        model.addAttribute("productList", productList);
        return "homepage";
    }

    @GetMapping("/list-category")
    public String listProductsByCategory(Model model)
    {
        List<Product> productList = (List<Product>) productRepository.findAllByCategory("Notebooks");

        log.info("Products found with findAllByCategory():");
        log.info("-------------------------------");
        for (Product product : productRepository.findAllByCategory("Notebooks")) {
            log.info(product.toString());
        }
        log.info("");

        model.addAttribute("productList", productList);
        return "homepage";
    }
}
