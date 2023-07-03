package com.jspider.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hibernate.dto.EmployeeDTO;

public class EmployeeInsertDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openconnection() {
		
		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
    private static void closeconnection() {
		
		if(factory!=null) {
			factory.close();		
	   }
        if(manager!=null) {
        	
        	manager.clear();       
        }
        if(transaction.isActive()) {
        	transaction.rollback();
        }
    }
    
    public static void main(String[] args) {
		
    	try {
    		
    		openconnection();
    		transaction.begin();
    		
    		EmployeeDTO emp1 = new EmployeeDTO();
    		emp1.setId(1);
    		emp1.setName("sara");
    		emp1.setDesignation("motivation");
    		emp1.setSalary(152);
    		
    		EmployeeDTO emp2 = new EmployeeDTO();
    		emp2.setId(2);
    		emp2.setName("shubman");
    		emp2.setDesignation("batsman");
    		emp2.setSalary(420);
    		
    		
    		manager.persist(emp1);
    		manager.persist(emp2);
    		
    		transaction.commit();
    		
    	}finally {
    		closeconnection();
			
		}
	}
}
