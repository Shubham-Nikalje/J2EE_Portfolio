package com.jspider.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hibernate.dto.EmployeeDTO;

public class EmployeeUpdateDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openconnection() {

		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeconnection() {

		if (factory != null) {
			factory.close();
		}
		if (manager != null) {

			manager.clear();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}

	public static void main(String[] args) {

		try {

			openconnection();
			transaction.begin();

			EmployeeDTO employee = manager.find(EmployeeDTO.class, 3);
			employee.setDesignation("Actor");

			transaction.commit();

		} finally {
			closeconnection();

		}
	}
}
