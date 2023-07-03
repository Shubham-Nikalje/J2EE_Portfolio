package com.jspider.springmvc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.springmvc1.pojo.StudentPOJO;
import com.jspider.springmvc1.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public StudentPOJO addStudent(String name, String email, long mobile,String address) {
		
		StudentPOJO pojo = repository.addStudent(name,email,mobile,address);
		
		return pojo;
	}
	
	public StudentPOJO searchStudent(int id) {
		StudentPOJO pojo = repository.searchStudent(id);
		
		return pojo;
	}

	public StudentPOJO removeStudent(int id) {
		
		StudentPOJO pojo = repository.removeStudent(id);
		
		return pojo;
	}

	public StudentPOJO searchStudents(int id) {
		StudentPOJO pojo = repository.searchStudent(id);
		return pojo;
	}

	public List<StudentPOJO> searchAllStudents() {
		List<StudentPOJO> students  = repository.searchAllStudents();
		return students;
	}
	

	public StudentPOJO updateStudent(int id, String name, String email, long mobile, String address) {
		StudentPOJO pojo = repository.updateStudent(id, name, email,mobile, address);
		return pojo;
	}
}
