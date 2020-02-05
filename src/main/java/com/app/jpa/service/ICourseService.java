package com.app.jpa.service;

import java.util.List;
import java.util.Optional;

import com.app.jpa.model.Course;

public interface ICourseService {
	
	public Optional<Course> findById(Long id);
	
	public List<Course> findAll();
	
	public Course save(Course course);
	
	public void deleteById(Long id);
	
	public Course updateCourse(Long id, Course course);
}
