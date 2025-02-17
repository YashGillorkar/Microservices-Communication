package com.yash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Product;
import com.yash.orderservice.ProductServiceClient;

@RestController
public class OrderController {
	
	 private final ProductServiceClient productServiceClient;

	    public OrderController(ProductServiceClient productServiceClient) {
	        this.productServiceClient = productServiceClient;
	    }

	    
	    @GetMapping("/orders/{id}")
	    public String createOrder(@PathVariable("id") Long productId) {
	        Product product = productServiceClient.getProductById(productId);
	        return "Order created for product: " + product.getName() + " with price: $" + product.getPrice();
	    }

}
