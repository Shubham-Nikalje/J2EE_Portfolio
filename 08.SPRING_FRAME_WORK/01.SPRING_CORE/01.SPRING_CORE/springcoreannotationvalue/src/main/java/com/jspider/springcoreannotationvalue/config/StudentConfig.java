package com.jspider.springcoreannotationvalue.config;

import org.springframework.context.annotation.Bean;

import com.jspider.springcoreannotationvalue.beans.StudentBean;


public class StudentConfig {
	
	@Bean("student1")
	public StudentBean getStudent() {
		
		return new StudentBean();
	}

}
