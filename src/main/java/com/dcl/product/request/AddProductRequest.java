package com.dcl.product.request;

import lombok.Data;

@Data
public class AddProductRequest {

	private String productName;

	private String brand;

	private Double price;

}
