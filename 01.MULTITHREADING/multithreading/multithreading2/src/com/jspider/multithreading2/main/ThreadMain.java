package com.jspider.multithreading2.main;

import com.jspider.multithreading2.threads.MyThread2;

public class ThreadMain {
	
	public static void main(String[] args) {
		
		//here we create object of Mythread2 for calling run method(implements inside it) by using start()
		//but MyThread2 implements with Runnable interface in runnable interface run() not available so  
		//run method present in Thread class so here we create the object of thread class but in thread class
		//presented run() is not implemented we want MyThread run() method implementation so here we pass the 
		//MyThread2 reference inside the thread object constructor(in Thread available different constructor)
		//so thread object behave like Mythread2 and now we call run method by using thread obj. reff. then we 
		//get implementation MyThread Run()
		MyThread2 myThread2 = new MyThread2();
		
		Thread thread = new Thread(myThread2);
		
		        thread.start();
	}

}
