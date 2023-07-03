package com.jspider.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspider.springcore.bean.StudentBean;

public class StudentMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("StudentConfg.xml");
		
		//getBean(StudentBean.class) is used when single obj. present in xml file
		 
		//StudentBean student = context.getBean(StudentBean.class);
		
		//getBean("student2") this passed object name is this method when more than one object present there 
		//we want to fetched multiple object fetched
		
		StudentBean student = (StudentBean) context.getBean("student1");
		StudentBean student1 = (StudentBean) context.getBean("student2");
		System.out.println(student);
		System.out.println(student1);
		((ClassPathXmlApplicationContext)context).close();
	}
}
