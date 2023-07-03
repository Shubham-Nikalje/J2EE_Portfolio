package com.jspider.springcoreonetoone.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspider.springcoreonetoone.bean.PersonBean;

public class PersonMain {

	public static void main(String[] args) {
				
	   ApplicationContext context = new ClassPathXmlApplicationContext("PersonConfg.xml");
	   PersonBean person = (PersonBean) context.getBean("person1");
	   System.out.println(person);
	   ((ClassPathXmlApplicationContext)context).close();	
	}
}
//here I got ClassNotFoundError due class name is not proper