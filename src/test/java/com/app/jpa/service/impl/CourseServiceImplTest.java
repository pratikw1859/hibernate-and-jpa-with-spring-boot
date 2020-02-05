package com.app.jpa.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import com.app.jpa.model.Course;
import com.app.jpa.repository.CourseRepository;
import com.app.jpa.service.ICourseService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class CourseServiceImplTest {
	
	@Autowired
	private ICourseService courseService;
	
	@MockBean
	private CourseRepository courseRepository;
	
	private Course course = null;
	
	@BeforeEach
	public void setup(){
		course = new Course(10L,"John",LocalDateTime.now(),LocalDateTime.now());
	}
	@Test
	public void testFindAll() {
		when(courseRepository.findAll()).thenReturn(Stream.of(new Course(1l,"john",LocalDateTime.now(),LocalDateTime.now()), 
				new Course(2l,"VK",LocalDateTime.now(),LocalDateTime.now())).collect(Collectors.toList()));
		assertEquals(2, courseService.findAll().size());
	}
	
	@Test
	@DirtiesContext
	public void testSave(){
		//Course course = new Course(1L, "John");
		when(courseRepository.save(course)).thenReturn(course);
		assertEquals(course, courseService.save(course));
	}
	
	@Test
	public void testFindById(){
		when(courseRepository.findById(course.getId())).thenReturn(Optional.of(course));
		assertEquals(Optional.of(course).get(), courseService.findById(course.getId()).get());
	}
	
	@Test
	@DirtiesContext
	public void testDeleteById(){
		log.info("Inside Delete Method");
		courseRepository.deleteById(course.getId());
		assertFalse(courseService.findById(course.getId()).isPresent());
	}
}
