package com.jspider.hibernatemanytomanybidirection.DTO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class SubjectDTO {

	@Id
	private int id;
	private String name;
	private int duration;
	//mappedBy used to data redanduncy avoid to create intermitted two tables
	@ManyToMany(mappedBy="subjects")
	private List<StudentDTO> students;
	
	}
