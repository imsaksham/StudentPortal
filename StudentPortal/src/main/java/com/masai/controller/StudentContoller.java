package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.StudentDto;
import com.masai.payload.ApiResponse;
import com.masai.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentContoller {
	@Autowired
	private StudentService studentService;
	@PostMapping("/student")
	public ResponseEntity<StudentDto> registerStudent(@RequestBody StudentDto student){
		return new ResponseEntity<>(studentService.createStudent(student),HttpStatus.CREATED);
	}
	@GetMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<StudentDto> assignCourse(@PathVariable long studentId,@PathVariable long courseId){
		return ResponseEntity.ok(studentService.assignCourse(studentId, courseId));
	}
	
	@GetMapping("/student/course/{courseId}")
	public ResponseEntity <List<StudentDto>> getStudentByCoursId(@PathVariable long cousrseId){
		return ResponseEntity.ok(studentService.getStudentByCourseId(cousrseId));
	}
	@PutMapping("student/{studentId}")
	public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto student,@PathVariable long studentId){
		
		return ResponseEntity.ok(studentService.update(studentId, student));
	}
	
	@GetMapping("/student/{name}")
	public ResponseEntity<List<StudentDto>> serchStudent(@PathVariable String name){
		return ResponseEntity.ok(studentService.getStudentByName(name));
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("Hello");
	}
	
	
	@GetMapping("/student/{studentId}/courses/{courseId}")
public ResponseEntity<ApiResponse>leveCourse(@PathVariable long studentId,@PathVariable long courseId){
	boolean status=studentService.leaveCourse(studentId, courseId);
	if(status) return ResponseEntity.ok(new ApiResponse("Leave Successfully",status));
	return ResponseEntity.ok(new ApiResponse("Some Thing went Wrong",status));
}

}
