package com.jspider.springcore.bean;

//OneToOne PersonBean to AadharBean

import lombok.Data;

@Data
public class PersonBean {

	int id;
	String name;
	String email;
	Long contact;
	AadharBean aadhar;
	
}
