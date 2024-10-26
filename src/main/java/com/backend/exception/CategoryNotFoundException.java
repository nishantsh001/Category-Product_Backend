package com.backend.exception;

public class CategoryNotFoundException extends RuntimeException{
	public CategoryNotFoundException(Long id) {
		super("Couldn't found user with id "+id);
	}
}
