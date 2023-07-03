package com.jspider.singletone.object;

public class SingletonLazy {

	private static SingletonLazy object;
	private static int count;
	
	private SingletonLazy() {
		count++;
		System.out.println("object created "+count+" times");
	}
	
	public static SingletonLazy getObject() {
		System.out.println("trying to create object");
		
		if(object==null) {
			
			object = new SingletonLazy();
		}
		return object;
	}

}
