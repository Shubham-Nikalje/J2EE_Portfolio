package com.jspider.multithreading6.resource;

public class Account {
	
//	this is a shared resources it execute for all threads at a time so out put get in the
//	form of inconsistency (varies output) for each execution for overcame this problem use
//  synchronized key word in source method
	
	//accountBalance is a non static variable
	int accountBalance;   
	
    //constructor of Account (initializer)	
	public Account (int accountBalance) {
		this.accountBalance=accountBalance;
	}
	
	
	public void checkBalance() {
		System.out.println("current Balance: "+accountBalance);
	}
	
	public void depositeAmount(int amount) {
		
		System.out.println("Deposite: "+amount+"rs in account");
		accountBalance +=amount;
	       checkBalance();
	}
	
	public void withdrawAmount(int amount) {
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
