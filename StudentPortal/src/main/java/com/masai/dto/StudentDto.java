package com.masai.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.masai.entity.Address;
import com.masai.entity.Course;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentDto {
	private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String uniqueStudentCode;
    private String email;
    private String mobile;
    private String parentName;
    private Set<Address> addresses = new HashSet<>();
    private Set<Course> courses = new HashSet<>();

    
    

}
