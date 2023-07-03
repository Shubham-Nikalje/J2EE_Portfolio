package com.jspider.multithreading6.threads;

import com.jspider.multithreading6.resource.Account;

public class Person2 extends Thread{

	Account account;
	public Person2 (Account account) {
		this.account=account;
	}
	
	@Override
	public void run() {
		account.depositeAmount(3000);
		account.withdrawAmount(1500);
	}
	
	
}
