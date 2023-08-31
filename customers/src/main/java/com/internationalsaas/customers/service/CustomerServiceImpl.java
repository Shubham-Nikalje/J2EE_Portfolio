package com.internationalsaas.customers.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.internationalsaas.customers.pojo.CustomerPOJO;
import com.internationalsaas.customers.repository.CustomerRepository;



@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<CustomerPOJO> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public CustomerPOJO saveCustomer(CustomerPOJO customer) {
		return customerRepository.save(customer);
	}

	@Override
	public CustomerPOJO getCustomerById(Long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public CustomerPOJO updateCustomer(CustomerPOJO customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerById(Long id) {
		customerRepository.deleteById(id);	
	}

}