package com.yash.orderservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yash.model.Product;

@Service
public class ProductServiceClient {

    private final RestTemplate restTemplate;
    private final String productServiceUrl;

    public ProductServiceClient(RestTemplate restTemplate, @Value("${product.service.url}") String productServiceUrl) {
        this.restTemplate = restTemplate;
        this.productServiceUrl = productServiceUrl;
    }

    public Product getProductById(Long productId) {
        return restTemplate.getForObject(productServiceUrl + "/" + productId, Product.class);
    }
}