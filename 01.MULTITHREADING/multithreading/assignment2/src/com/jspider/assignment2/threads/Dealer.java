package com.jspider.assignment2.threads;

import com.jspider.assignment2.resource.Showroom;

public class Dealer extends Thread {

	Showroom showroom;
	
	public Dealer(Showroom showroom) {
		this.showroom=showroom;
	}
	
	@Override
	public void run() {
		showroom.restockbikes(10);
	}
}
