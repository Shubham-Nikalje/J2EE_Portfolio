package com.jspider.springrest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.springrest.pojo.StudentPOJO;
import com.jspider.springrest.response.StudentResponse;
import com.jspider.springrest.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE,
			                     produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentPOJO pojo){
		StudentPOJO student = service.addStudent(pojo);
		StudentResponse response = new StudentResponse();
		//Success Flow
		if(student != null) {
			response.setMessage("Data inserted succesfuly");
			response.setData(student);
			return new ResponseEntity<StudentResponse>(response,HttpStatus.ACCEPTED);	
		}
		//Failure Flow
		response.setMessage("Data not inserted");
		return new ResponseEntity<StudentResponse>(response,HttpStatus.BAD_REQUEST);	
	}
	
	@GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> searchStudent(@RequestBody StudentPOJO pojo){
		StudentPOJO student = service.searchStudent(pojo.getId());
		//Success Flow
		if(student != null) {
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("Data found successfully..",student,null),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("Data not found...",null,null),HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping(path = "/searchAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> SearchAllStudent(@RequestBody StudentPOJO pojo){
		List<StudentPOJO> students = service.searchAllStudent();
		if(students != null) {
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("Data Found succesfully",null,students),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("No student data found",null,null),HttpStatus.FOUND);
	}
	
	
	
	
}
