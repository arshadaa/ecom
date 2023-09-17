package com.arshad.exception;

public class CategoryTypeNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2344360133976960706L;

	public CategoryTypeNotFoundException() {
	}

	public CategoryTypeNotFoundException(String message) {
		super(message);
	}
}
