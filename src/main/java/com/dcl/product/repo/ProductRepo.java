package com.dcl.product.repo;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcl.product.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	Optional<Product> findByProductName(String productName);

	List<Product> findAll();

	Optional<Product> findByProductId(Integer productId);
}
