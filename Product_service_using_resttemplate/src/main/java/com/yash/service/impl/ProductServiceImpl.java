package com.yash.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.entity.Product;
import com.yash.exception.InvalidProductIdException;
import com.yash.model.dto.ProductRequestDTO;
import com.yash.model.dto.ProductResponseDTO;
import com.yash.repository.ProductRepository;
import com.yash.service.ProductServiceI;
import com.yash.utils.ProductMapper;

@Service
public class ProductServiceImpl implements ProductServiceI {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductResponseDTO getProductOnId(Long id) {
		return productRepository.findById(id).map(product -> ProductMapper.convertToResponseDTO(product))
				.orElseThrow(() -> new InvalidProductIdException("Product not found with id: " + id));
	}

	@Override
	public ProductResponseDTO addProduct(ProductRequestDTO entity) {
		Product product = productRepository.save(ProductMapper.convertToProduct(entity));
		return ProductMapper.convertToResponseDTO(product);
	}

	@Override
	public List<ProductResponseDTO> getAllProducts() {
		List<ProductResponseDTO> listDTO = new ArrayList<ProductResponseDTO>();
		for (Product product : productRepository.findAll()) {
			listDTO.add(ProductMapper.convertToResponseDTO(product));
		}
		return listDTO;
	}

}
