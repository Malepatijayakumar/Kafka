package com.appsdeveloperblog.ws.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.ws.product.dto.ProductDto;
import com.appsdeveloperblog.ws.product.error.ErrorResponse;
import com.appsdeveloperblog.ws.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	private final ProductService productService;

	@PostMapping
	public ResponseEntity<Object> createProduct(@RequestBody ProductDto productDto) {
		String productId;
		try {
			productId = productService.createProduct(productDto);
		} catch (Exception e) {
			LOGGER.error("Exception occurred : " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ErrorResponse(productDto.getTitle(), e.getMessage()));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(productId);
	}
}
