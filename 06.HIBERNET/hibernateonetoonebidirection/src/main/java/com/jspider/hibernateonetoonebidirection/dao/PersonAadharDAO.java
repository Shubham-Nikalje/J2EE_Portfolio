package com.jspider.hibernateonetoonebidirection.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hibernateonetoonebidirection.dto.AadharDTO;
import com.jspider.hibernateonetoonebidirection.dto.PersonDTO;

public class PersonAadharDAO {

	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openconnection() {
		
		factory = Persistence.createEntityManagerFactory("OneToOne");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
    private static void closeconnection() {
		
		if(factory!=null) {
			factory.close();		
	   }
        if(manager!=null) {
        	
        	manager.close();       
        }
        if(transaction.isActive()) {
        	transaction.rollback();
        }
    }
    
    public static void main(String[] args) {
		
    	try {
    		
    		openconnection();
    		transaction.begin();
    		
    		

    		PersonDTO person1 = new PersonDTO();
    		person1.setId(3);
    		person1.setName("Shubham");
    		person1.setContact(7387573265L);
    		person1.setDob("12-07-1999");
    		person1.setAddress("Pune");
    		

    		
    		
    		AadharDTO aadhar = new AadharDTO();
    		aadhar.setId(3);
    		aadhar.setAadhar_no(123456987789L);
    		aadhar.setDoi("01-05-2015");
    		
    		
    		
    		aadhar.setPersonDTO(person1);
    		manager.persist(aadhar);
    		
    		person1.setAadharDTO(aadhar);
    		manager.persist(person1);
    		
    		transaction.commit();
    		
    	}finally {
    		closeconnection();
			
		}
	}
}
