package com.app.jpa.service;

import java.util.List;

import com.app.jpa.model.Course;

public interface ICourseService {
	
	public Course findById(Long id);
	
	public List<Course> findAll();
	
	public Course save(Course course);
	
	public void deleteById(Long id);
}
