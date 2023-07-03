package com.jspider.multithreading4.threads;

public class MyThread2 implements Runnable {
	
	
	//Each Thread have property like 1.Name 2.Priority.
	//we access this property by using non-static helper method 1.getter(get()) 2.setter(set()).
	//getter and setter method present in Thread class.
	//here no any connection with Thread class so,
	//*static(access by using class name) currentThread() method is present in Thread class it point toward
	//*current executing object so by using currentThread() we can access property of current executing class.
	//*currentThread is static property access by using class name like Thread.currentthread
	
	@Override
	public void run() {
		System.out.println("Name of thread: "+Thread.currentThread().getName());
		System.out.println("priority of thread: "+Thread.currentThread().getPriority());
	}

}
