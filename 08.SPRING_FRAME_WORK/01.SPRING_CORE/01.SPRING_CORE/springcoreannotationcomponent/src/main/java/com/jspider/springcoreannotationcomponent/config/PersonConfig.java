package com.jspider.springcoreannotationcomponent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.jspider.springcoreannotationcomponent.beans.PersonBean;

@ComponentScan(basePackages = "com.jspider.springcoreannotationcomponent")
public class PersonConfig {

	@Bean("person1")
	public PersonBean getPerson() {
		return new PersonBean();
	}
	
}
