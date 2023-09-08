package com.masai.service;

import java.util.List;

import com.masai.dto.CourseDto;

public interface CourseService {
	public CourseDto uploadCourse(CourseDto courseDto);
	public CourseDto getCourseById(long courseId);
	public List<CourseDto> searchTopic(String topic);

}
