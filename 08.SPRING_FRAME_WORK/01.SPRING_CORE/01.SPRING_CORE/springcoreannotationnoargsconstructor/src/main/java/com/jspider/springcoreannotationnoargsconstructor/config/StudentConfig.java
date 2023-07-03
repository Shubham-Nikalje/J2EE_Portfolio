package com.jspider.springcoreannotationnoargsconstructor.config;

import org.springframework.context.annotation.Bean;

import com.jspider.springcoreannotationnoargsconstructor.beans.StudentBean;

public class StudentConfig {
	
	@Bean("student1")
	public StudentBean getStudent() {
		
		return new StudentBean();
	}

}
