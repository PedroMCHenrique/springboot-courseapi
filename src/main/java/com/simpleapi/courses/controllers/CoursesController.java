package com.simpleapi.courses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simpleapi.courses.Entity.Course;
import com.simpleapi.courses.dtos.CoursePayloadDTO;
import com.simpleapi.courses.dtos.CourseResponseDTO;
import com.simpleapi.courses.services.CoursesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CoursesController {
	
	@Autowired
	private CoursesService coursesService;
	
	@GetMapping
	public List<Course> getAll() {
		return this.coursesService.findAll();
	}
	
	@GetMapping("{id}")
	public CourseResponseDTO getById(@PathVariable Long id) {
		return this.coursesService.findById(id);
	}
	
	@PostMapping
	public CourseResponseDTO create(@Valid @RequestBody CoursePayloadDTO courseDTO) {
		return this.coursesService.create(courseDTO);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		this.coursesService.delete(id);
	}
	
	@PutMapping("{id}")
	public CourseResponseDTO update(@Valid @RequestBody CoursePayloadDTO newCourse, @PathVariable Long id) {
		return this.coursesService.update(newCourse, id);
	}
	
}
