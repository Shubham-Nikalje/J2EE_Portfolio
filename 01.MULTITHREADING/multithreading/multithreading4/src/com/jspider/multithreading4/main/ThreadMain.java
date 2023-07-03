package com.jspider.multithreading4.main;

import com.jspider.multithreading4.threads.MyThread1;
import com.jspider.multithreading4.threads.MyThread2;

public class ThreadMain {

	////Each Thread have property like 1.Name 2.Priority.
	//we access this property by using non-static helper method 1.getter(get()) 2.setter(set()).
	//getter and setter method present in Thread class.
	
	//(set() & get() non static method so)here we given value by creating object.
	//we can given priority between 1 to 10
	// 1=minimum priority 5=is medium priority 10=high priority
	//priority increases 1 to 10 (10 priority need to execute 1st than 1 priority)
	
	public static void main(String[] args) {
		
		MyThread1 myThread1 = new MyThread1();
		myThread1.setName("Thread-1");
		myThread1.setPriority(9);
		
		MyThread2 myThread2 = new MyThread2();
		Thread thread = new Thread(myThread2);
		thread.setName("Thread-2");
		thread.setPriority(10);
		
		myThread1.start();
		thread.start();	
	}
}
