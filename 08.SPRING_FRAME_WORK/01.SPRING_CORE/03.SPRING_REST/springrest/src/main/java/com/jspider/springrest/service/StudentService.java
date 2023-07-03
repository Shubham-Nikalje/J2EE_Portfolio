package com.jspider.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.springrest.pojo.StudentPOJO;
import com.jspider.springrest.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	public StudentPOJO addStudent(StudentPOJO pojo) {
		StudentPOJO student = repository.addStudent(pojo);
		
		return student;
	}

	public StudentPOJO searchStudent(int id) {
		StudentPOJO student = repository.searchStudent(id);
		return student;
	}

	public List<StudentPOJO> searchAllStudent() {
	    List<StudentPOJO> students = repository.searchAllStudent();
		return students;
	}


}
