package com.jspider.adapterpattern.adapter;

import com.jspider.adapterpattern.Entity.Employee;
import com.jspider.adapterpattern.Entity.Event;

public class EmpEventAdaptor extends Employee implements Event{
	
	@Override
	public void womensDay() {
		System.out.println("chief guest of event is: "+this.name);
		System.out.println("here designation is: "+this.designation);	
		
	}
	

}
