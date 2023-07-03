package com.jspider.springcoreannotationcomponent.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class PersonBean {

	@Value("1")
	int id;
	@Value("shubham")
	String name;
	@Value("shubh12@gmail.com")
	String email;
	@Autowired
	AadharBean aadhar;
}
