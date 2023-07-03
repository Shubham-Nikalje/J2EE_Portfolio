package com.jspider.multithreading3.threads;


public class MyThread2 implements Runnable {
	public void run() {
		for (int i = 0; i <=5; i++) {
			
			System.out.println("My Thread2 is now running");	
		}	
	}
}
