package com.jspiders.spirngcoreannotation.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class PersonBean {

	@Value("1")
	int id;
	@Value("Sanket")
	String name;
	@Value("sanket@gmail.com")
	String email;
	@Autowired
	AadharBean aadhar;
}
