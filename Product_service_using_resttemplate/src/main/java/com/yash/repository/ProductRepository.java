package com.yash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
