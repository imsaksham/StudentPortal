package com.masai.serviceImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.masai.Repo.CourseRepo;
import com.masai.Repo.StudentRepo;
import com.masai.dto.StudentDto;
import com.masai.entity.Course;
import com.masai.entity.Student;
import com.masai.exception.ResourceNotFoundException;
import com.masai.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo studentRepo ;
	
	@Autowired
	private CourseRepo courseRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	

	@Override
	public StudentDto createStudent(StudentDto student) {
		Student st=studentRepo.save(modelMapper.map(student, Student.class));
		return modelMapper.map(st, StudentDto.class);
	}

	@Override
	public StudentDto assignCourse(long studentId, long courseId) {
		
		Student student=studentRepo.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student", "StudentId", studentId));
		Course course=courseRepo.findById(courseId).orElseThrow(()->new ResourceNotFoundException("course", "courseId", courseId));
		Set<Course>courses=new HashSet<>();
		courses.add(course);
		student.setCourses(courses);
		return modelMapper.map(student, StudentDto.class);
	}

	@Override
	public List<StudentDto> getStudentByName(String StudentName) {
		List<Student> students=studentRepo.findAll();
		List<StudentDto> studentDtoList = students.stream()
			    .map(student -> modelMapper.map(student, StudentDto.class))
			    .collect(Collectors.toList());		
		
		return studentDtoList;
	}

	@Override
	public List<StudentDto> getStudentByCourseId(long courseId) {
		Course course=courseRepo.findById(courseId).orElseThrow(()->new ResourceNotFoundException("course", "courseId", courseId));
		
		Long studentId=course.getStudent_id();
		Student student=studentRepo.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student", "StudentId", studentId));
		List<Student> students=Arrays.asList(student);
		List<StudentDto> studentDtoList = students.stream()
			    .map(std -> modelMapper.map(std, StudentDto.class))
			    .collect(Collectors.toList());	
		
		return studentDtoList;
	}

	@Override
	public  StudentDto update(long studentId, StudentDto student) {
		// TODO Auto-generated method stub
		Student std=studentRepo.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student", "StudentId", studentId));
		
		std.setEmail(student.getEmail());
		std.setMobile(student.getMobile());
		std.setParentName(student.getParentName());
		std.setAddresses(student.getAddresses());
		studentRepo.save(std);
		return modelMapper.map(std, StudentDto.class) ;
	}

	@Override
	public List<String> sreachAssignTopic(StudentDto student, String topic) {
		
		Student std=modelMapper.map(student, Student.class);
		
		Set<String> searchTopic=std.getCourses().stream().flatMap(course->course.getTopics().stream()).collect(Collectors.toSet());
		
		List<String> assignTopic=searchTopic.stream().filter(sTopics->sTopics.contains(topic)).collect(Collectors.toList());
		
		return assignTopic;
	}

	@Override
	public Boolean leaveCourse(long studentId, long courseId) {
		Student student=studentRepo.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student", "StudentId", studentId));
		Course course=courseRepo.findById(courseId).orElseThrow(()->new ResourceNotFoundException("course", "courseId", courseId));
		
		if(student.getCourses().contains(course)) {
			student.getCourses().remove(course);
			studentRepo.save(student);
			return true;
		}
		return false;
	}

}
