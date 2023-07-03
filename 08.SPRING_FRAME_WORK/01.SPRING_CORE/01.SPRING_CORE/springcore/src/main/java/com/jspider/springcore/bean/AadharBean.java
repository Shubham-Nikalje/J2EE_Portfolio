package com.jspider.springcore.bean;

//OneToOne PersonBean to AadharBean

import lombok.Data;

@Data
public class AadharBean {

	int id;
	String aadhar_no;
	String date_of_issue;
}
