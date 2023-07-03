package com.jspider.springcore.bean;

//ManyToOne Player to Team

import lombok.Data;

@Data
public class PlayerBean {

	int id;
	String name;
	int age;
	TeamBean team;
	
}
