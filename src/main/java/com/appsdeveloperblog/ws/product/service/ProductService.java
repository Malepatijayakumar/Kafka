package com.appsdeveloperblog.ws.product.service;

import com.appsdeveloperblog.ws.product.dto.ProductDto;

public interface ProductService {
	
	String createProduct(ProductDto productDto) throws Exception;

}
