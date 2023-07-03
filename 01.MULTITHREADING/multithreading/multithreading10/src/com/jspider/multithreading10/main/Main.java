package com.jspider.multithreading10.main;

import com.jspider.multithreading10.resource.Resource;
import com.jspider.multithreading10.threads.Thread1;
import com.jspider.multithreading10.threads.Thread2;

public class Main {
public static void main(String[] args) {
	Resource resource=new Resource();
	
	Thread1 thread1=new Thread1(resource);
	thread1.setName("T1");
	
	Thread2 thread2=new Thread2(resource);
	thread2.setName("T2");
	
	
	thread1.start();
	thread2.start();
}
}
