package com.appsdeveloperblog.ws.product.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.ws.product.dto.ProductDto;
import com.appsdeveloperblog.ws.product.event.ProductCreatedEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

	@Override
	public String createProduct(ProductDto productDto) throws Exception {
		String productId = UUID.randomUUID().toString();
		/**
		 * Asynchronous kafka message
		 */
//		CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate
//				.send("product-created-events-topic", productId, new ProductCreatedEvent(productId,
//						productDto.getTitle(), productDto.getPrice(), productDto.getQuantity()));
//		future.whenComplete((result, exception) -> {
//			if (exception != null) {
//				LOGGER.error("****** Failed to send message ", exception.getMessage());
//			} else {
//				LOGGER.info("****** Message sent successfully " + result.getRecordMetadata());
//			}
//		});
		/**
		 * Synchronous kafka message (waiting for acknowledgement)
		 */
		SendResult<String, ProductCreatedEvent> response = kafkaTemplate
				.send("product-created-events-topic", productId, new ProductCreatedEvent(productId,
						productDto.getTitle(), productDto.getPrice(), productDto.getQuantity()))
				.get();
		LOGGER.info("******* Metadata "+response.getRecordMetadata());
		LOGGER.info("******* Completed execution returning product ID");
		return productId;
	}
}