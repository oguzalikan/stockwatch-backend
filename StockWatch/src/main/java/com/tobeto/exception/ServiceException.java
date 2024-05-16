package com.tobeto.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = -309140238380688123L;

	public static enum ERROR_CODES {
		PRODUCT_NOT_FOUND(1, "Product not found."), SHELF_NOT_FOUND(2, "Shelf not found."),
		NOT_ENOUGH_SHELF(3, "Not enough shelf."), SHELF_HAS_PRODUCTS(4, "Shelf has products."),
		SET_SHELF_COUNT(5, "You cannot set capacity less than the number of products in the shelf.");

		private int code;
		private String message;

		private ERROR_CODES(int code, String message) {
			this.code = code;
			this.message = message;
		}

		public int getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

	}

	private int code;
	private String message;

	public ServiceException(ERROR_CODES errorCode) {
		this.code = errorCode.getCode();
		this.message = errorCode.getMessage();
	}
}
