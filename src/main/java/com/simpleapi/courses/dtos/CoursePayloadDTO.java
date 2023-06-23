package com.simpleapi.courses.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record CoursePayloadDTO(
		@NotBlank(message = "name is required")
		@Length(min = 3, message = "name must have at least 3 characters long")
		String name) {

}
