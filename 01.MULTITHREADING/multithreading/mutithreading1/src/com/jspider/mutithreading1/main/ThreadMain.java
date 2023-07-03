package com.jspider.mutithreading1.main;

import com.jspider.mutithreading1.threads.MyThread1;

public class ThreadMain {
	
//	main ctrl +space for getting main()
	public static void main(String[] args) {
		
//		MyThread1 ctr+space for getting proper formate if enter then get import of that class
		MyThread1 myThread1 = new MyThread1();
		
		 myThread1.start();
	}
	
}
