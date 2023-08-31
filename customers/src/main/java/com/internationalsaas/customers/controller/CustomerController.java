package com.internationalsaas.customers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.internationalsaas.customers.pojo.CustomerPOJO;
import com.internationalsaas.customers.service.CustomerService;



@Controller
public class CustomerController {
	
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	// handler method to handle list customers and return mode and view
	@GetMapping("/customers")
	public String listStudents(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}
	
	@GetMapping("/customers/new")
	public String createStudentForm(Model model) {
		
		// create customer object to hold student form data
		CustomerPOJO customer = new CustomerPOJO();
		model.addAttribute("customer", customer);
		return "create_customer";
		
	}
	
	@PostMapping("/customers")
	public String saveCustomer(@ModelAttribute("customer") CustomerPOJO customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customers";
	}
	
	@GetMapping("/customers/edit/{id}")
	public String editCustomerForm(@PathVariable Long id, Model model) {
		model.addAttribute("customer", customerService.getCustomerById(id));
		return "edit_customer";
	}

	@PostMapping("/customers/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("customer") CustomerPOJO customer,
			Model model) {
		
		// get customer from database by id
		CustomerPOJO existingStudent = customerService.getCustomerById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(customer.getFirstName());
		existingStudent.setLastName(customer.getLastName());
		existingStudent.setAddress(customer.getAddress());
		existingStudent.setCity(customer.getCity());
		existingStudent.setState(customer.getState());
		existingStudent.setEmail(customer.getEmail());
		
		// save updated customer object
		customerService.updateCustomer(existingStudent);
		return "redirect:/customers";		
	}
	
	// handler method to handle delete customer request
	
	@GetMapping("/customers/{id}")
	public String deleteStudent(@PathVariable Long id) {
		customerService.deleteCustomerById(id);
		return "redirect:/customers";
	}
	
}
