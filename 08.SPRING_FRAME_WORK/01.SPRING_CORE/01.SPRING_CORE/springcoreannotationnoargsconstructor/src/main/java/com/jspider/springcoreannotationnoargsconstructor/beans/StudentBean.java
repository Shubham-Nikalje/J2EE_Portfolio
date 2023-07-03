package com.jspider.springcoreannotationnoargsconstructor.beans;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBean {

    @Value("1")
	int id;
    @Value("shubham")
	String name;
    @Value("shubh12@gmqil.com")
	String email;
	
}
