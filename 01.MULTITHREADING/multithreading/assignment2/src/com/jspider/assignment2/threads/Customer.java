package com.jspider.assignment2.threads;

import com.jspider.assignment2.resource.Showroom;

public class Customer extends Thread {

	Showroom showroom;
	
	public Customer(Showroom showroom) {
		this.showroom=showroom;
	}
	
	@Override
	public void run() {
		showroom.orderBike(10);
	}
}
