package com.jspider.springcore.bean;

import java.util.List;

import lombok.Data;

//OneToMany Company to Employee

@Data
public class CompanyBean {

	int id;
	String name;
	String location;
	List<EmployeeBean> employees;
}
