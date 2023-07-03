package com.jspider.springcore.main;

//ManyToOne Player to Team

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspider.springcore.bean.PlayerBean;

public class PlayerMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("PlayerConfg.xml");
		PlayerBean player1 = (PlayerBean) context.getBean("player1");
		PlayerBean player2 = (PlayerBean) context.getBean("player2");
		PlayerBean player3 = (PlayerBean) context.getBean("player3");
		System.out.println(player1);
		System.out.println(player2);
		System.out.println(player3);
		((ClassPathXmlApplicationContext)context).close();

	}
}
