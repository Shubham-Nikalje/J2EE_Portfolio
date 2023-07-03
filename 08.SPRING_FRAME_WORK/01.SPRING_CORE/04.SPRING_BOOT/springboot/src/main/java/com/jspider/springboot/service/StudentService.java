package com.jspider.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.springboot.pojo.StudentPOJO;
import com.jspider.springboot.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public StudentPOJO addStudent(StudentPOJO pojo) {
		StudentPOJO student = repository.save(pojo);
		return student;
	}
	
	public StudentPOJO searchStudent(int id) {
		StudentPOJO student = repository.findById(id).orElse(null);
		return student;
	}
	
	public List<StudentPOJO> searchAllStudents() {
		List<StudentPOJO> students = repository.findAll();
		return students;
	}
	
	
	public StudentPOJO searchByName(String name) {
		StudentPOJO student = repository.findByName(name);
		return student;
	}
	
	public StudentPOJO searchByAddress(String address) {
		StudentPOJO student = repository.findByAddress(address);
		return student;
	}
}
