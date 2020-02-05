package com.app.jpa.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.jpa.model.Course;
import com.app.jpa.service.ICourseService;

@RestController
@RequestMapping("/services/course")
public class CourseController {
	
	private ICourseService courseService;

	public CourseController(ICourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping("/{id}")
	public Course findById(@PathVariable("id") Long id) {
		return courseService.findById(id).get();
	}
	
	@GetMapping
	public List<Course> findAll(){
		return courseService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Course course){
		Course savedInDb = courseService.save(course);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedInDb.getId()).toUri();
		return ResponseEntity.created(location).body(savedInDb);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		courseService.deleteById(id);
		return ResponseEntity.ok("Course With Id:".intern()+id+" Deleted.".intern());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCourse(@PathVariable("id") Long id, @RequestBody Course course){
		Course updateCourse = courseService.updateCourse(id, course);
		return ResponseEntity.ok(updateCourse);
	}
}
