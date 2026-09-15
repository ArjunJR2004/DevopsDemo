package com.dcl.product.service;

import java.util.List;


import com.dcl.product.dto.ProductDto;
import com.dcl.product.request.AddProductRequest;

public interface ProductService {

	ProductDto addProduct(AddProductRequest request);
	
	List<ProductDto> getAllProducts();
	
	ProductDto getProductById(Integer productId);
	
	
}
