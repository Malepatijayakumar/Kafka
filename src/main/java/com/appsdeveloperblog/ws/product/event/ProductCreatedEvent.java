package com.appsdeveloperblog.ws.product.event;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreatedEvent {
	private String productId;
	private String title;
	private BigDecimal price;
	private Integer quantity;
}
