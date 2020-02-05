package com.app.jpa.service.impl;

import java.util.List;
import java.util.Optional;

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
	public Optional<Course> findById(Long id) {
		return courseRepo.findById(id);
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

	@Override
	public Course updateCourse(Long id, Course course) {
		if(courseRepo.findById(id).isPresent()) {
			Course existingCourse = courseRepo.findById(id).get();
			existingCourse.setName(course.getName());
			Course updatedCourse = courseRepo.save(existingCourse);
			return updatedCourse;
		}
		else {
			throw new RuntimeException("Course Not Present");
		}
	}

}
