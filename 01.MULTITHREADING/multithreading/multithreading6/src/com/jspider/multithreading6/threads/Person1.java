package com.jspider.multithreading6.threads;

import com.jspider.multithreading6.resource.Account;

public class Person1 extends Thread{

	Account account;
	public Person1 (Account account) {
		this.account=account;
	}
	
	@Override
	public void run() {
		account.depositeAmount(5000);
		account.withdrawAmount(3000);
	}
}
