package com.jspider.hibernateonetomany.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EmployeeDTO {

	@Id
	 private int id;
	 private String name;
	 private String email;
	 private int salary;
	 private String designation;
	 
	
}
