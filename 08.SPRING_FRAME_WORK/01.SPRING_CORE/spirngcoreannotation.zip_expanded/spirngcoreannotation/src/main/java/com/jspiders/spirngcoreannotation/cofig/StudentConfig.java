package com.jspiders.spirngcoreannotation.cofig;

import org.springframework.context.annotation.Bean;

import com.jspiders.spirngcoreannotation.beans.StuddentBean;

public class StudentConfig {

	@Bean("student1")
	public StuddentBean getBean() {
//		StuddentBean student = new StuddentBean();
		return new StuddentBean();
	}
}
