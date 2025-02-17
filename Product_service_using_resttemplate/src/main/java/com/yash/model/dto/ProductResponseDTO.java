package com.yash.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDTO {

	private Long id;

	private String name;

	private Double price;

}
