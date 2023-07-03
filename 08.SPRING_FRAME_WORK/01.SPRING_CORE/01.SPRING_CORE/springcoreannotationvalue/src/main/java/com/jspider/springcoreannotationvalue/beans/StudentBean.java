package com.jspider.springcoreannotationvalue.beans;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class StudentBean {

    @Value("1")
	int id;
    @Value("shubham")
	String name;
    @Value("shubh12@gmqil.com")
	String email;
	
}
