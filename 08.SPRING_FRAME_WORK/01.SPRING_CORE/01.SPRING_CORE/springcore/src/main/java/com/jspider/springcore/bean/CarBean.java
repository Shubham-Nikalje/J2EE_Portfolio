package com.jspider.springcore.bean;

import java.util.List;

import lombok.Data;

//ManyToMany Car to Driver (one direction)

@Data
public class CarBean {

	int car_no;
	String car_company;
	List<DriverBean> drivers;
	
	
}
