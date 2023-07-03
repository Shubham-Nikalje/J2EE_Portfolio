package com.jspider.multithreading5.threads;

public class Thread1 extends Thread {
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		
		for (int i = 0; i <= 5; i++) {
			
			if(i>2) {
				this.stop();
				
			}
			
			System.out.println("now MyThread 1 is running");
		}
	}

}
