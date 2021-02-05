package com.example.poorstore;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/add-client").setViewName("new-client");
		registry.addViewController("/add-product").setViewName("new-product");
		registry.addViewController("/remove-product").setViewName("remove-product");
		registry.addViewController("/add-order").setViewName("new-order");
		registry.addViewController("/homepage").setViewName("homepage");
		registry.addViewController("/shopping-cart").setViewName("shopping-cart");
		registry.addViewController("/advanced-search").setViewName("advanced-search");
		registry.addViewController("/product").setViewName("product");
		registry.addViewController("/about").setViewName("about-this-page");
		registry.addViewController("/list-category").setViewName("list-category");
	}

}
