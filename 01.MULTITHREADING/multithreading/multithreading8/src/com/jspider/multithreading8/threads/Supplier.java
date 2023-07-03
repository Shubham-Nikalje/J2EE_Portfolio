package com.jspider.multithreading8.threads;

import com.jspider.multithreading8.resource.Shop;

public class Supplier extends Thread {
	
	Shop shop;
	
	public Supplier(Shop shop) {
		
	       this.shop=shop;
	}
	@Override
	public void run() {
	      shop.restockProducts(20);
	}
}
