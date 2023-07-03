package com.jspider.hibernatejpql.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TrainerDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String jpql;
	private static Query query;
	
	public static void openconnection() {
		
		factory = Persistence.createEntityManagerFactory("jpql");
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
		if(transaction.isActive()) {
			transaction.getRollbackOnly();
		}
	}
	
	
	public static void main(String[] args) {
		
		try {
			openconnection();
			transaction.begin();
			
			jpql ="from TrainerDAO";
		    query =manager.createQuery(jpql);
		    
		    List<TrainerDAO> trainers = query.getResultList();
		    
		    for(TrainerDAO trainer :trainers) {
		    	
		    System.out.println(trainer);
		    }
		    transaction.commit();    
		}catch (Exception e) {
		   e.printStackTrace();
		}finally {
			closeconnection();
		}
	}

}

