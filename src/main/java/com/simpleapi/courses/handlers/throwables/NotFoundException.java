package com.simpleapi.courses.handlers.throwables;

public class NotFoundException extends RuntimeException {
	
	public <T> NotFoundException(Class<T> cls) {
		super(String.format("%s not found", cls.getSimpleName()));
	}
}
