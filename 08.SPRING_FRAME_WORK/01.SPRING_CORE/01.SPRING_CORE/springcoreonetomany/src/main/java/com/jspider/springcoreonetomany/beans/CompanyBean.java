package com.jspider.springcoreonetomany.beans;

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
