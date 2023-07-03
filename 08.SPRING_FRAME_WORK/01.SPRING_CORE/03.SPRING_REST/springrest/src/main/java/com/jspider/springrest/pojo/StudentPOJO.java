package com.jspider.springrest.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="stud_details")
public class StudentPOJO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="stud_id")
	private int id;
	@Column(name="stud_name")
	private String name;
	@Column(name="stud_email")
	private String email;
	@Column(name="contact")
	private long contact;
	@Column(name="address")
	private String address;
	
	
}
