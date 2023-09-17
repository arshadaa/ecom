package com.arshad.exception;

public class CategoryNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CategoryNotFoundException() {
	}

	public CategoryNotFoundException(String message) {
		super(message);
	}
}
