package com.jspiders.spirngcoreannotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.spirngcoreannotation.beans.PersonBean;
import com.jspiders.spirngcoreannotation.cofig.PersonConfig;

public class PersonMain {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
		PersonBean person = (PersonBean)context.getBean("person1");
		System.out.println(person);
		((AnnotationConfigApplicationContext)context).close();
		
	}
}
