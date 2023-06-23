package com.simpleapi.courses.Entity;

import com.simpleapi.courses.dtos.CoursePayloadDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
@Entity
@Table(name = "courses")
public class Course {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	public Course(CoursePayloadDTO courseDTO) {
		this.setName(courseDTO.name());
	}

}
