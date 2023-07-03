package com.jspider.springcoremanytomany.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspider.springcoremanytomany.beans.CarBean;


public class CarDriverMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("CarDriverConfg.xml");
		CarBean car1 = (CarBean) context.getBean("car1");
		CarBean car2 = (CarBean) context.getBean("car2");
		System.out.println(car1);
		System.out.println(car2);
		((ClassPathXmlApplicationContext)context).close();
		
	}
}
