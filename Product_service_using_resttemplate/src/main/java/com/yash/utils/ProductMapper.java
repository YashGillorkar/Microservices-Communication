package com.yash.utils;

import com.yash.entity.Product;
import com.yash.model.dto.ProductRequestDTO;
import com.yash.model.dto.ProductResponseDTO;

public class ProductMapper {

    public static Product convertToProduct(ProductRequestDTO requestDTO) {
        return new Product(requestDTO.getName(), requestDTO.getPrice());
    }

    public static ProductResponseDTO convertToResponseDTO(Product product) {
        return new ProductResponseDTO(product.getId(), product.getName(), product.getPrice());
    }
}
