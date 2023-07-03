package com.jspider.singletone.object;

public class SingletonEager {

	private static SingletonEager object = new SingletonEager() ;
	private int count;
	
	private SingletonEager() {
		count++;
		System.out.println("object created"+count+"times");
	}
	
	public static SingletonEager getObject() {
		
		System.out.println("trying to create object");
		return object;	
	}
	
}
