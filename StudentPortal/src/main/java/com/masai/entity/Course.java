package com.masai.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Course {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;

    private String courseName;
    private String description;
    private String courseType;
    private int durationInMonths;
    
    @ElementCollection
    private List<String> topics;
}


