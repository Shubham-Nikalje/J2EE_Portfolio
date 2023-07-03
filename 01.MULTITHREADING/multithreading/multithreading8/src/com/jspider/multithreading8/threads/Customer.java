package com.jspider.multithreading8.threads;

import com.jspider.multithreading8.resource.Shop;

public class Customer extends Thread {
	
	Shop shop;
	
	//argument comes from main shop for available product
	
	public Customer(Shop shop) {
		
	       this.shop=shop;
	}
	@Override
	public void run() {
	      shop.orderProducts(10);
	}
}
