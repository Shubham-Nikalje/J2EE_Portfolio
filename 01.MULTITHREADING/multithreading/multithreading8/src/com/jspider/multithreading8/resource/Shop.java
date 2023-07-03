package com.jspider.multithreading8.resource;

public class Shop {
     int availableOProducts;
     
     public Shop(int availableProducts) {
    	 this.availableOProducts= availableProducts;
     }
     
     public synchronized void orderProducts(int noofProducts) {
    	 System.out.println("trying to purchase"+noofProducts+"products");
    	 
    	 if(noofProducts>availableOProducts) {
    		 System.out.println(noofProducts+"products not available");
    		 System.out.println("Please wait...");
// exception get(add try and catch) when only type this.wait()
// wait() is non static method is present in Thread class(override in Thread class actual in superObject class)
// here we use wait() is used to call thread running state to wait state
    		 try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	 }
    	 
    	 availableOProducts -= noofProducts; 
    	 System.out.println(noofProducts+" product purchased");
    	 System.out.println("noofavilableProduct: "+availableOProducts);
     }
     
     public synchronized void restockProducts(int noofProducts) {
    	 System.out.println("Restockin"+noofProducts+"products");
    	 availableOProducts += noofProducts;
    	 
    	 System.out.println("now available products: "+availableOProducts);
    	 
//notify() is present in Thread class(Override) actual in object class 
// it is used call thread waiting state to running state it don't resume automatically
//thread only resume it receive call from notify()    	 
    	 this.notify();
     }
}
    	 
    	

