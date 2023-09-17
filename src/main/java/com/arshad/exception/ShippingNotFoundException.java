package com.arshad.exception;

public class ShippingNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShippingNotFoundException() {
	}

	public ShippingNotFoundException(String message) {
		super(message);
	}
}
