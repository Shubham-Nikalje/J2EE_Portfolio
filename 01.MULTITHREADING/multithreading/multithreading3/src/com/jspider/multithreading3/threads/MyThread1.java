package com.jspider.multithreading3.threads;

public class MyThread1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i <=5; i++) {
			
			System.out.println("My Thread1 is now running");
				}	
	    }
}
