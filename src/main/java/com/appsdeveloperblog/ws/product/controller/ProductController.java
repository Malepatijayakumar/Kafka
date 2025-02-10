package com.appsdeveloperblog.ws.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.ws.product.dto.ProductDto;
import com.appsdeveloperblog.ws.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	
	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody ProductDto productDto){
		String productId = productService.createProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productId);
	}
}
