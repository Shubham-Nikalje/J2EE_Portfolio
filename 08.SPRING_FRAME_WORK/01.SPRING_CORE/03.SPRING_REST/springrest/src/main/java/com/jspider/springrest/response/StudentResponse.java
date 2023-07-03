package com.jspider.springrest.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspider.springrest.pojo.StudentPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

	private String Message;
	private StudentPOJO data;
	private List<StudentPOJO> list;

}
