package com.simpleapi.courses.handlers.throwables;

public class ThrowableFactory {

	public static <T> NotFoundException createNotFoundException(Class<T> cls) {
		return new NotFoundException(cls);
	}
	
}
