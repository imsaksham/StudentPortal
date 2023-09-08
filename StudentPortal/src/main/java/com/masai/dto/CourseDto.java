package com.masai.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CourseDto {
	private Long student_id;

    private String courseName;
    private String description;
    private String courseType;
    private int durationInMonths;
    
    
    private List<String> topics;

}
