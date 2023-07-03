package com.jspider.multithreading3.main;

import com.jspider.multithreading3.threads.MyThread1;
import com.jspider.multithreading3.threads.MyThread2;

public class ThreadMain {
	public static void main(String[] args) {
		
		//here multithreade is processing(calling run() of both thread) at a time so here multithreading happen.
		
		MyThread1 myThread1 = new MyThread1();
		
		MyThread2 myThread2 = new MyThread2();
		Thread thread       = new Thread(myThread2);
		
	     thread.start();
	     myThread1.start();
	     
	     //here getting o/p not constant because we are executing more than thread they are executing with 
	     //the help of ThreadSchedual is a component of JVM.  ThreadSchedual call the thread and provoid seperate stack to each thread
	     //and transfer control between them so we can't decide or don't know which thread are executing..
	     //stack executing once at a time due to JVM calling but here ThreadSchedual executing multiple 
	     //stack at a time so multithreading possible
	}

}
