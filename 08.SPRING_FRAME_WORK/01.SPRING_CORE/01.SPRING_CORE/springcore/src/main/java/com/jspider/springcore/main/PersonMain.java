package com.jspider.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspider.springcore.bean.PersonBean;

//OneToOne PersonBean to AadharBean

public class PersonMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("PersonConfg.xml");
		PersonBean personBean = (PersonBean) context.getBean("person1");
		System.out.println(personBean);
		((ClassPathXmlApplicationContext)context).close();
	}
}
