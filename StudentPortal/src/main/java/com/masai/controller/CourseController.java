package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.CourseDto;
import com.masai.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/course")
	public ResponseEntity<CourseDto> uploadCourse(@RequestBody CourseDto course){
		CourseDto cs=courseService.uploadCourse(course);
		return new  ResponseEntity<>(cs,HttpStatus.CREATED);
		
	}
	@GetMapping("/course/{name}")
	public ResponseEntity<List<CourseDto>> searchCourseByTopic(@PathVariable String name){
		
		List<CourseDto> course=courseService.searchTopic(name);
		return ResponseEntity.ok(course);
	}
	@GetMapping("/course/{courseId}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable long courseId){
		CourseDto course=courseService.getCourseById(courseId);
		return ResponseEntity.ok(course);
	}

}
