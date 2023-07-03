package com.jspider.assignment2.main;

import com.jspider.assignment2.resource.Showroom;
import com.jspider.assignment2.threads.Customer;
import com.jspider.assignment2.threads.Dealer;

public class ShowroomMain {

	public static void main(String[] args) {
		Showroom showroom =  new Showroom(5);
		
		Customer customer = new Customer(showroom);
		Dealer dealer = new Dealer(showroom);
		
		customer.start();
		dealer.start();
	}
}
