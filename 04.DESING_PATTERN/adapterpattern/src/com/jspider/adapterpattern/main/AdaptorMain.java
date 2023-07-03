package com.jspider.adapterpattern.main;

import com.jspider.adapterpattern.adapter.EmpEventAdaptor;

public class AdaptorMain {
	public static void main(String[] args) {
		
		EmpEventAdaptor adaptor = new EmpEventAdaptor();
		adaptor.id=1;
		adaptor.name="shubh";
		adaptor.contact="1234569878L";
		adaptor.designation="JavaDeveloper";
		
		adaptor.womensDay();
		
	}

}
