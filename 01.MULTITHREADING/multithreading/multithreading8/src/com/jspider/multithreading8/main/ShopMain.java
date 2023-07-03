package com.jspider.multithreading8.main;

import com.jspider.multithreading8.resource.Shop;
import com.jspider.multithreading8.threads.Customer;
import com.jspider.multithreading8.threads.Supplier;

public class ShopMain {

	public static void main(String[] args) {
		Shop shop = new Shop(5);
		
		Customer customer = new Customer(shop);
		Supplier supplier = new Supplier(shop);
		
		customer.start();
		supplier.start();
	}
}
