package com.yash.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data 
public class ProductRequestDTO {

	@NotBlank(message = "Product Name cannot be blank")
	private String name;

	@Positive(message = "Price must be positive")
	@Min(value = 1, message = "Price must be at least 1")
	private Double price;

}
