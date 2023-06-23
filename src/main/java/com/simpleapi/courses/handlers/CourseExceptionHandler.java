package com.simpleapi.courses.handlers;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CourseExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		List<FieldError> errors = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(errors.stream().map((error) -> new HashMap<String, String>() {
			{
				put("field", error.getField());
				put("message", error.getDefaultMessage());
			}
		}).toList());
	}
}
