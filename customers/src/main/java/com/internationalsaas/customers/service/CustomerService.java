package com.internationalsaas.customers.service;

import java.util.List;

import com.internationalsaas.customers.pojo.CustomerPOJO;


public interface CustomerService {
	List<CustomerPOJO> getAllCustomers();
	
	CustomerPOJO saveCustomer(CustomerPOJO customer);
	
	CustomerPOJO getCustomerById(Long id);
	
	CustomerPOJO updateCustomer(CustomerPOJO customer);
	
	void deleteCustomerById(Long id);
}
