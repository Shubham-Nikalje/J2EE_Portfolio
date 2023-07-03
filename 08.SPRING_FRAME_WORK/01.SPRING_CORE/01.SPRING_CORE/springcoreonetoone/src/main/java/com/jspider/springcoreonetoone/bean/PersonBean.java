package com.jspider.springcoreonetoone.bean;

import lombok.Data;

@Data
public class PersonBean {

	int id;
	String name;
	String email;
	Long contact;
	AadharBean aadhar;
}
