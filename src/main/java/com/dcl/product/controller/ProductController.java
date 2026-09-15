package com.dcl.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcl.product.dto.ProductDto;
import com.dcl.product.request.AddProductRequest;
import com.dcl.product.response.ApiResponse;
import com.dcl.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService pservice;
	
	@PostMapping("/add")
	public ResponseEntity<?> addProduct(AddProductRequest request){
		ProductDto pdto = pservice.addProduct(request);
		return ResponseEntity.ok(new ApiResponse("Product Added successfully", pdto, HttpStatus.OK));
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getAllProducts(){
		List<ProductDto> pdtoList = pservice.getAllProducts();
		return ResponseEntity.ok(new ApiResponse("Product List", pdtoList, HttpStatus.OK));
	}
	
	@GetMapping("/get/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable Integer productId){
		ProductDto pdto = pservice.getProductById(productId);
		return ResponseEntity.ok(new ApiResponse("Product Details", pdto, HttpStatus.OK));
	}
}
