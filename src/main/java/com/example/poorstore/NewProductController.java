package com.example.poorstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewProductController {

    private static final Logger log = LoggerFactory.getLogger(NewProductController.class);

    @Autowired
    private ProductRepository repository;

    @PostMapping("/new-product")
    public String newClient(
            @RequestParam(name="productName", required=false, defaultValue="World") String productName,
            @RequestParam(name="price", required=false, defaultValue="") Integer price,
            @RequestParam(name="quantity", required=false, defaultValue="") Integer quantity,
            @RequestParam(name="description", required=false, defaultValue="") String description,
            Model model)
    {

        repository.save(new Product(productName, description, price, quantity));

        log.info("Products found with findAll():");
        log.info("-------------------------------");
        for (Product aProduct : repository.findAll()) {
            log.info(aProduct.toString());
        }
        log.info("");

        model.addAttribute("productName", productName);
        model.addAttribute("description", description);
        model.addAttribute("price", price);
        model.addAttribute("quantity", quantity);

        return "new-product-view";
    }
}