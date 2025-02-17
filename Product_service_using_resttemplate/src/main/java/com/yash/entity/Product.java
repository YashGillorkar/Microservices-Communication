package com.yash.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "product_id")
	private Long id;

	@Column(name = "product_name")
	private String name;

	@Column(name = "product_price")
	private Double price;

}
