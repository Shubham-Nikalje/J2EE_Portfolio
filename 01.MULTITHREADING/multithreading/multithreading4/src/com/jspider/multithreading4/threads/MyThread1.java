package com.jspider.multithreading4.threads;

public class MyThread1 extends Thread {
	
	//Each Thread have property like 1.Name 2.Priority.
	//we access this property by using non-static helper method 1.getter(get()) 2.setter(set()).
	//getter and setter method present in Thread class.
	//here we already extends with Thread class so we can easily access get() set() in this class.
	//here we use this keyword to access same class property.
	
	
	@Override
	public void run() {
		System.out.println("Name of Thread: "+this.getName());
		System.out.println("Priority of Thread: "+this.getPriority());
		
	}

}
