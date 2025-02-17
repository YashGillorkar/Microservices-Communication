package com.yash.service;

import java.util.List;

import com.yash.model.dto.ProductRequestDTO;
import com.yash.model.dto.ProductResponseDTO;

public interface ProductServiceI {

	ProductResponseDTO getProductOnId(Long id);

	ProductResponseDTO addProduct(ProductRequestDTO entity);

	List<ProductResponseDTO> getAllProducts();
	

}
