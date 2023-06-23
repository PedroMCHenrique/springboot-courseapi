package com.simpleapi.courses.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleapi.courses.Entity.Course;
import com.simpleapi.courses.Repositories.CourseRepository;
import com.simpleapi.courses.dtos.CoursePayloadDTO;
import com.simpleapi.courses.dtos.CourseResponseDTO;
import com.simpleapi.courses.handlers.throwables.ThrowableFactory;


@Service
public class CoursesService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> findAll() {
		return this.courseRepository.findAll();
	}
	
	public CourseResponseDTO findById(Long id) {
		Course course = this.courseRepository.findById(id)
				.orElseThrow(() -> ThrowableFactory.createNotFoundException(Course.class));
		return CourseResponseDTO.fromEntity(course);
	}
	
	public CourseResponseDTO create(CoursePayloadDTO courseDTO) {
		Course newCourse = this.courseRepository.save(new Course(courseDTO));
		return CourseResponseDTO.fromEntity(newCourse);
	}
	
	public void delete(Long id) {
		this.findById(id);
		this.courseRepository.deleteById(id);
	}
}
