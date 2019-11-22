package com.app.jpa.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.jpa.model.Course;
import com.app.jpa.repository.CourseRepository;
import com.app.jpa.service.ICourseService;

@SpringBootTest
public class CourseServiceImplTest {
	
	@Autowired
	private ICourseService courseService;
	
	@MockBean
	private CourseRepository courseRepository;
	
	private Course course = null;
	
	@BeforeEach
	public void setup(){
		course = new Course(1L,"John");
	}
	@Test
	public void testFindAll() {
		when(courseRepository.findAll()).thenReturn(Stream.of(new Course(1l,"john"), new Course(2l,"VK")).collect(Collectors.toList()));
		assertEquals(2, courseService.findAll().size());
	}
	
	@Test
	public void testSave(){
		//Course course = new Course(1L, "John");
		when(courseRepository.save(course)).thenReturn(course);
		assertEquals(course, courseService.save(course));
	}
	
	@Test
	public void testFindById(){
		when(courseRepository.findById(course.getId())).thenReturn(Optional.of(course));
		assertEquals(Optional.of(course).get(), courseService.findById(course.getId()));
	}
}
