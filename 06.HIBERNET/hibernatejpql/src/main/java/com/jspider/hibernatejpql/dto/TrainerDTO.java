package com.jspider.hibernatejpql.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Trainer-Details")
public class TrainerDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "t_id")
	private int id;
	@Column(name="t_name")
	private String name;
	@Column(name="t_sub")
	private String subject;
	@Column(name="t_email")
	private String email;
	

}