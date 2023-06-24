package com.simpleapi.courses.handlers;


import java.util.HashMap;
import java.util.Map;

import com.simpleapi.courses.handlers.throwables.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, String> handleRunTimeException(RuntimeException ex) {
		
		Map<String, String> response = new HashMap<>() {
			{
				put("message", ex.getMessage());
				put("statusCode", "500");
				put("trace", ex.getStackTrace().toString());
			}
		};
		return response;
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, String> handleEntityNotFoundException(NotFoundException ex) {
		Map<String, String> response = new HashMap<>() {
			{
				put("message", ex.getMessage());
				put("statusCode", "404");
			}
		};
		return response;
	}
}
