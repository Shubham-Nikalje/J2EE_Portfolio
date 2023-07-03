package com.jspider.singletone.main;

import com.jspider.singletone.object.SingletonEager;
import com.jspider.singletone.object.SingletonLazy;

public class SingletonMain {

	public static void main(String[] args) {
		
		SingletonLazy lazy1 = SingletonLazy.getObject();
	    System.out.println(lazy1);
	    SingletonLazy lazy2 = SingletonLazy.getObject();
	    System.out.println(lazy2);
	    
	    SingletonEager eager1 = SingletonEager.getObject();
	    System.out.println(eager1);
	    SingletonEager eager2 = SingletonEager.getObject();
	    System.out.println(eager2);
	}
    
}
