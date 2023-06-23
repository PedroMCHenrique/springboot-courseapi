package com.simpleapi.courses.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleapi.courses.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
