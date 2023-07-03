package com.jspiders.spirngcoreannotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.spirngcoreannotation.beans.StuddentBean;
import com.jspiders.spirngcoreannotation.cofig.StudentConfig;

public class StudentMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
		StuddentBean student = (StuddentBean)context.getBean("student1");
		System.out.println(student);
		
		((AnnotationConfigApplicationContext)context).close();
		
	}
}
