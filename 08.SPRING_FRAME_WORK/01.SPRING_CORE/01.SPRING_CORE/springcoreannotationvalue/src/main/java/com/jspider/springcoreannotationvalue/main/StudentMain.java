package com.jspider.springcoreannotationvalue.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspider.springcoreannotationvalue.beans.StudentBean;
import com.jspider.springcoreannotationvalue.config.StudentConfig;


public class StudentMain {

	//AnnotationConfigApplicationContext is used with for annotation class instead ClassPathXmlApplication
		public static void main(String[] args) {
			
		ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
		StudentBean student = context.getBean(StudentBean.class);
		System.out.println(student);
		((AnnotationConfigApplicationContext)context).close();
		
		}
}
//I got here ClassNotfoundException due to dependency of Spring-core & spring-context not same.
//i resolved it by given same version of both dependency.