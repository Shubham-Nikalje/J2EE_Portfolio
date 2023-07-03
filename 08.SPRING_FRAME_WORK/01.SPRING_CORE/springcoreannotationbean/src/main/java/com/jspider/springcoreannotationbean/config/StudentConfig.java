package com.jspider.springcoreannotationbean.config;

import org.springframework.context.annotation.Bean;

import com.jspider.springcoreannotationbean.beans.StudentBean;

import lombok.Data;

//@Bean annotation used for creating configurl class instead of <bean> tag from xml file.

@Data
public class StudentConfig {

	@Bean("student1")
	public StudentBean getStudent() {
		
		StudentBean student = new StudentBean();
		student.setId(1);
		student.setName("shubham");
		student.setEmail("shubh12@gmail.com");
		
		return student;
	}
}
