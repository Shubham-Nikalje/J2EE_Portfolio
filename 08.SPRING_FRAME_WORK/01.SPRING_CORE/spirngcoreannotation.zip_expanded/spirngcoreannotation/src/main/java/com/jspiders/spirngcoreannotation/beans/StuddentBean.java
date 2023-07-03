package com.jspiders.spirngcoreannotation.beans;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class StuddentBean {


	@Value("1")
	int id;
	@Value("Sanket")
	String name;
	@Value("123456789")
	long contact;
}
