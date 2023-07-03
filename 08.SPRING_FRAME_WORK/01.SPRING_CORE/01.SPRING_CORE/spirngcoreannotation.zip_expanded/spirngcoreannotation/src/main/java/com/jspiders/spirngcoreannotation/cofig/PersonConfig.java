package com.jspiders.spirngcoreannotation.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.jspiders.spirngcoreannotation.beans.PersonBean;

@ComponentScan(basePackages = "com.jspiders.spirngcoreannotation")
public class PersonConfig {

	@Bean("person1")
	public PersonBean getBean() {
		return new PersonBean();
	}
}
