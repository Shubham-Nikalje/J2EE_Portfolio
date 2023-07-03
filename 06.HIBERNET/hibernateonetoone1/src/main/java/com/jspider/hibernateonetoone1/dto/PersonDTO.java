package com.jspider.hibernateonetoone1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class PersonDTO {

@Id
	
	private int id;
	private String name;
	private long contact;
	private String dob;
	private String address;
	
}
