package com.masai.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repo.CourseRepo;
import com.masai.dto.CourseDto;
import com.masai.entity.Course;
import com.masai.exception.ResourceNotFoundException;
import com.masai.service.CourseService;
@Service
public class CourseServiceimpl implements CourseService {
	
	@Autowired
	private CourseRepo courseRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CourseDto uploadCourse(CourseDto courseDto) {
		Course course=courseRepo.save(modelMapper.map(courseDto, Course.class));
		
		return modelMapper.map(course, CourseDto.class);
	}

	@Override
	public CourseDto getCourseById(long courseId) {
		Course course=courseRepo.findById(courseId).orElseThrow(()->new ResourceNotFoundException("course", "courseId", courseId));

		return modelMapper.map(course, CourseDto.class);
	}

	@Override
	public List<CourseDto> searchTopic(String name) {
		List<Course> topics=courseRepo.findBycourseName(name);
		
		List<CourseDto> courses=topics.stream().map(cs->modelMapper.map(cs, CourseDto.class)).collect(Collectors.toList());
		return courses;
	}

}
