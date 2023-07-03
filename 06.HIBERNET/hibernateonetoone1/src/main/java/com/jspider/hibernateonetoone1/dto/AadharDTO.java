package com.jspider.hibernateonetoone1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class AadharDTO {


	@Id
	private int id;
	private long aadhar_no;
	private String doi;
	
	@OneToOne
	private PersonDTO personDTO;
}
