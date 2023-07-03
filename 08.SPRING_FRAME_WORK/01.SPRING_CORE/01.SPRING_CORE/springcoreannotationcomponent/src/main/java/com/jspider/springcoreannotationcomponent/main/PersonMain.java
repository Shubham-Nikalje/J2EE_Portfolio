package com.jspider.springcoreannotationcomponent.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspider.springcoreannotationcomponent.beans.PersonBean;
import com.jspider.springcoreannotationcomponent.config.PersonConfig;

public class PersonMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
		PersonBean person1 = (PersonBean)context.getBean("person1");
		System.out.println(person1);
		((AnnotationConfigApplicationContext)context).close();
				
	}
}

//I got here ClassNotfoundException due to dependency of Spring-core & spring-context not same.
//i resolved it by given same version of both dependency.
