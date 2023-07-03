package com.jspider.multithreading7.resource;

public class Account {
	
//	synchronized - for maintain consistency of output
	
//	this is a shared resources it execute for all threads at a time so out put get in the
//	form of inconsistency (varies output) for each execution for overcame this problem use
//  synchronized key word in source method
//  due to synchronized keyword  resource are execute once at a time with one thread 
//	in synchronized concept lock apply on resources so it execute at a time for one thread
//	1.class lock - shared resource is static then class lock applied
//	2.Object lock - shared resource is static then Object lock applied
	
	//accountBalance is a non static variable
	int accountBalance;   
	
    //constructor of accountBalance (initializer)	
	public Account (int accountBalance) {
		this.accountBalance=accountBalance;
	}
	
	
	public void checkBalance() {
		System.out.println("current Balance: "+accountBalance);
	}
	
	public synchronized void depositeAmount(int amount) {
		
		System.out.println("Deposite: "+amount+"rs in account");
		accountBalance +=amount;
	       checkBalance();
	}
	
	public synchronized void withdrawAmount(int amount) {
		System.out.println("Trying to withdraw"+amount+"rs from account");
		
		if(amount>accountBalance) {
			System.out.println("insufficient Balance");
		}
		else {
		       accountBalance -=amount;
		       checkBalance();
		}
	}

}
