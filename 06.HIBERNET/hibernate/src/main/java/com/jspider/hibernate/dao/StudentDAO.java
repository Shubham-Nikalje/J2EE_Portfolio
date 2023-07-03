package com.jspider.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hibernate.dto.StudentDTO;

public class StudentDAO {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory =   Persistence.createEntityManagerFactory("hibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		StudentDTO student1 = new StudentDTO();
		student1.setSid(2);;
		student1.setSname("shubham");
		student1.setSemail("shubh@12gmail.com");
		student1.setSmarks(70);
		student1.setSadd("Pune");
		
		entityManager.persist(student1);
		
		entityTransaction.commit();
		
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();	
		}
		if(entityManager!=null) {
			entityManager.close();
		}
		if(entityTransaction.isActive()) {
			entityTransaction.rollback();
		}
		}
	}
