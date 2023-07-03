package com.jspider.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.springboot.pojo.StudentPOJO;

public interface StudentRepository extends JpaRepository<StudentPOJO, Integer> {
	
	StudentPOJO findByName(String name);
	
	StudentPOJO findByAddress(String address);

}
