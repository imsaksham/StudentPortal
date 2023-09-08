package com.masai.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

	List<Course> findBycourseName(String topic);

}
