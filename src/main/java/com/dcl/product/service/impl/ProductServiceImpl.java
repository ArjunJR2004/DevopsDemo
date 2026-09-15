package com.dcl.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dcl.product.dto.ProductDto;
import com.dcl.product.entity.Product;
import com.dcl.product.exception.AppException;
import com.dcl.product.repo.ProductRepo;
import com.dcl.product.request.AddProductRequest;
import com.dcl.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo prepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ProductDto addProduct(AddProductRequest request) {
		Product alreadyExists = prepo.findByProductName(request.getProductName()).orElse(null);
		
		if(alreadyExists != null) {
			throw new AppException("product already exists!", HttpStatus.CONFLICT);
		}
		Product product = mapper.map(request, Product.class);
		product = prepo.save(product);
		ProductDto pdto = mapper.map(product, ProductDto.class);
		return pdto;
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> plist = prepo.findAll();
		List<ProductDto> pdtoList = new ArrayList<>();
		for(Product product : plist) {
			ProductDto pdto = mapper.map(product, ProductDto.class);
			pdtoList.add(pdto);
		}
		return pdtoList;
	}

	@Override
	public ProductDto getProductById(Integer productId) {
		Product product = prepo.findByProductId(productId).orElse(null);
		if(product==null) {
			throw new AppException("Product not found", HttpStatus.NOT_FOUND);
		}
		return mapper.map(product, ProductDto.class);
	}

	
}
