package com.jspider.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
//this annotation display an entity class
@Data
//data anotation useful to generate getter,to string,hashcode ,equals implementation
@Table(name="emp")
//table annotation given for table specify table name as mension in table
public class EmployeeDTO {
	@Id
	//is annotation specify primary key of an entity
	@Column(name="empno")
	//column annotation used for given name of specific column of table
	private int id;
	@Column(name="ename")
	private String name;
	@Column (name="job")
	private String designation;
	@Column (name="sal")
	private double  salary;
}
	
