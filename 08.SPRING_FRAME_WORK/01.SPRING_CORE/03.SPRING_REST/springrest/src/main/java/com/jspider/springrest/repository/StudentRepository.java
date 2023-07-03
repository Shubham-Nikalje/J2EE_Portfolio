package com.jspider.springrest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspider.springrest.pojo.StudentPOJO;

@Repository
public class StudentRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String jpql;
	private static Query query;
	
	public static void openConnection() {
		
		factory = Persistence.createEntityManagerFactory("rest");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	public static void closeconnection() {
		if(factory!=null) {
			factory.close();
		}
		if(manager!=null) {
			manager.close();
		}
		if(transaction!=null) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public StudentPOJO addStudent(StudentPOJO pojo) {
		openConnection();
		transaction.begin();
		manager.persist(pojo);
		transaction.commit();
		closeconnection();
		return pojo;
	}

	public StudentPOJO searchStudent(int id) {
		openConnection();
		transaction.begin();
		StudentPOJO student = manager.find(StudentPOJO.class,id);
		if(student != null) {
			transaction.commit();
			closeconnection();
			return student;
		}
		transaction.commit();
		closeconnection();
		return null;
	}

	public List<StudentPOJO> searchAllStudent() {
		openConnection();
		transaction.begin();
		jpql = "from StudentPOJO";
		query = manager.createQuery(jpql);
		List<StudentPOJO> students = query.getResultList();
		transaction.commit();
		closeconnection();
		return students;
	}
	
}
