package com.app.jpa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.jpa.model.Course;
import com.app.jpa.repository.CourseRepository;
import com.app.jpa.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {
	
	private CourseRepository courseRepo;
	
	public CourseServiceImpl(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}

	@Override
	public Course findById(Long id) {
		return courseRepo.findById(id).get();
	}

	@Override
	public List<Course> findAll() {
		return courseRepo.findAll();
	}

	@Override
	public Course save(Course course) {
		return courseRepo.save(course);
	}

	@Override
	public void deleteById(Long id) {
		courseRepo.deleteById(id);
	}

}
