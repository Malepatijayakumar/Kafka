package com.appsdeveloperblog.ws.product.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	private String title;
	private String errorMessage;
}
