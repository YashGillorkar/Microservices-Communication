package com.yash.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Product;
import com.yash.orderservice.ProductServiceClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
	    
	    
	    @GetMapping("/orders2/{id}")
	    public void createOrder2(@PathVariable("id") Long productId) {
	        ResponseEntity<Product> responseEntity = productServiceClient.getProductById2(productId);
	        System.out.println(responseEntity.getBody());
	        System.out.println(responseEntity.getStatusCode());
	    }
	    
	    @PostMapping("/postorder")
	    public ResponseEntity<Product> postProductfromService(@RequestBody Product entity) {
	    	return new ResponseEntity<Product>(productServiceClient.saveProduct(entity),HttpStatus.ACCEPTED);
	    }
	    

}
