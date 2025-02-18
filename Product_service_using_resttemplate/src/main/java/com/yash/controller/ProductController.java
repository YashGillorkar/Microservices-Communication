package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entity.Product;
import com.yash.model.dto.ProductRequestDTO;
import com.yash.model.dto.ProductResponseDTO;
import com.yash.service.ProductServiceI;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/api/products")
@RestController
public class ProductController {

	@Autowired
	private ProductServiceI productServiceI;

	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable("id") Long id) {
		return new ResponseEntity<ProductResponseDTO>(productServiceI.getProductOnId(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO entity) {
		return new ResponseEntity<ProductResponseDTO>(productServiceI.addProduct(entity), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductResponseDTO>> getAllProduct() {
		return new ResponseEntity<List<ProductResponseDTO>>(productServiceI.getAllProducts(), HttpStatus.OK);
	}
	
	@PutMapping("/upadate/{id}")
	public ResponseEntity<ProductResponseDTO> updateProductDetails(@PathVariable Long id, @RequestBody Product entity) {
		return new ResponseEntity<ProductResponseDTO>(productServiceI.updateProduct(id,entity), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
	    productServiceI.deleteProduct(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	
	

}