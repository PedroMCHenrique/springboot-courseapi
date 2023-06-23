package com.simpleapi.courses.dtos;

import com.simpleapi.courses.Entity.Course;

public record CourseResponseDTO(Long id, String name) {
	
	public static CourseResponseDTO fromEntity(Course course) {
		return new CourseResponseDTO(course.getId(), course.getName());
	}
}
