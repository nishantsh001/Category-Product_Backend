package com.backend.exception;

public class ProductNotFoundException extends RuntimeException{
	public ProductNotFoundException(Long id) {
		super("Not found ith product id "+id);
	}
}
