package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	

}
