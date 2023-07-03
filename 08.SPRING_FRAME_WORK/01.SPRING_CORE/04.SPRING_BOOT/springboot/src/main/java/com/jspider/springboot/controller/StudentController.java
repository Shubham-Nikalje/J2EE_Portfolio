package com.jspider.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.springboot.pojo.StudentPOJO;
import com.jspider.springboot.response.StudentResponse;
import com.jspider.springboot.service.StudentService;

@Controller
public class StudentController {

	@Autowired 
	private StudentService service;
	
	@PostMapping("/add")
	public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentPOJO pojo){
		StudentPOJO student = service.addStudent(pojo);

		if(student != null) {
			//success
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("Data inserted successfuly",student,null),HttpStatus.ACCEPTED);
		}
		//failure
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("Data not inserted",null,null),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<StudentResponse> searchStudent(@PathVariable int id){
		StudentPOJO student = service.searchStudent(id);
		if(student != null) {
			//success
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("Student Data found",student,null),HttpStatus.FOUND);
		}
		//failure
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("Student Data not found",null,null),HttpStatus.NOT_FOUND);
		}
	
	@GetMapping("/searchAll")
	public ResponseEntity<StudentResponse> searchAllStudents(){
		List<StudentPOJO> students = service.searchAllStudents();
		if(students != null) {
			//success
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("Student Data found",null,students),HttpStatus.FOUND);
		}
		//failure
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("Student Data not found",null,null),HttpStatus.NOT_FOUND);
		}
	
	@GetMapping("/searchByName/{name}")
	public ResponseEntity<StudentResponse> searchStudentByName(@PathVariable String name){
		StudentPOJO student = service.searchByName(name);
		if(student != null) {
			//success
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("Student Data found",student,null),HttpStatus.FOUND);
		}
		//failure
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("Student Data not found",null,null),HttpStatus.NOT_FOUND);
		}
	
	@GetMapping("/searchByAddress/{address}")
	public ResponseEntity<StudentResponse> searchStudentByAddress(@PathVariable String address){
		StudentPOJO student = service.searchByAddress(address);
		if(student != null) {
			//success
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("Student Data found",student,null),HttpStatus.FOUND);
		}
		//failure
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("Student Data not found",null,null),HttpStatus.NOT_FOUND);
		}
	
	

}
