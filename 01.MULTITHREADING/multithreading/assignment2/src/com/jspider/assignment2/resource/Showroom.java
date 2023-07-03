package com.jspider.assignment2.resource;

public class Showroom {

	int availablebikes;
	
	public Showroom(int bikesavailable) {
		this.availablebikes=bikesavailable;
	}

	public synchronized void orderBike(int orderbike){
		
		System.out.println("No.of Bikes Ordered: "+ orderbike);
		
		if(availablebikes<orderbike) {
			
			System.out.println("Bike currently not in Stock");
			System.out.println("Please wait.....");
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		availablebikes-=orderbike;
		System.out.println("Succesfully ordered: "+orderbike+" bike");
		System.out.println("Available bike after ordered: "+availablebikes);
	}
	
	public synchronized void restockbikes (int restockbikes) {
		
		System.out.println("No.Of restock bikes: "+restockbikes);
		availablebikes+=restockbikes;
		System.out.println("restock succesfuly: "+restockbikes+" bikes");
		System.out.println("Available bikes after restock: "+availablebikes);
		
		this.notify();
		
	}
}
