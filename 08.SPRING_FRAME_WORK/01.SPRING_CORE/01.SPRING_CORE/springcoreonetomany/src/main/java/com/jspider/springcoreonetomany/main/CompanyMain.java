package com.jspider.springcoreonetomany.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspider.springcoreonetomany.beans.CompanyBean;


//OneToMany Company to Employee

public class CompanyMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("CompanyConfg.xml");
		CompanyBean company = (CompanyBean) context.getBean("company");
		System.out.println(company);
		((ClassPathXmlApplicationContext)context).close();
	}
}
