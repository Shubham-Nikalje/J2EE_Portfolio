package com.jspider.multithreading6.main;

import com.jspider.multithreading6.resource.Account;
import com.jspider.multithreading6.threads.Person1;
import com.jspider.multithreading6.threads.Person2;

public class AccountMain {

	public static void main(String[] args) {
		
		Account account = new Account(10000);
		
		Person1 person1 = new Person1(account);
		Person2 person2 = new Person2 (account);
		
		person1.start();
		person2.start();
	}
}
