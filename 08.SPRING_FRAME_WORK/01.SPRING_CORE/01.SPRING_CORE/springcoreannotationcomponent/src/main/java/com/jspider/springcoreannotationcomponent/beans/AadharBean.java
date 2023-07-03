package com.jspider.springcoreannotationcomponent.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AadharBean {

	@Value("1")
	int id;
	@Value("12364789632")
	long aadhar_no;
	@Value("13-june-2020")
	String date;
	
}
