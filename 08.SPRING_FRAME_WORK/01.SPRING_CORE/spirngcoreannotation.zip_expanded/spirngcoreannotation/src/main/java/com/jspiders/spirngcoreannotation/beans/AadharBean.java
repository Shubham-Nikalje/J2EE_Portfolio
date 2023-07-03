package com.jspiders.spirngcoreannotation.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AadharBean {

	@Value("1")
	int id;
	@Value("123456789123")
	long aadhar_no;
	@Value("1-june-2016")
	String date_of_issue;
	
}
