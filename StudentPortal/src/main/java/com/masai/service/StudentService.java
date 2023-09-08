package com.masai.service;


import java.util.List;

import com.masai.dto.StudentDto;

public interface StudentService {
	public StudentDto createStudent(StudentDto student);
	public StudentDto assignCourse(long studentId,long courseId);
	public List<StudentDto> getStudentByName(String StudentName);
	public List<StudentDto> getStudentByCourseId(long courseId);
	public StudentDto update(long studentId,StudentDto student);
	
	public List<String> sreachAssignTopic(StudentDto student,String topic);
	public Boolean leaveCourse(long studentId,long courseId);
	
	

}
