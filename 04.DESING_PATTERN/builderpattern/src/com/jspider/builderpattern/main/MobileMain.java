package com.jspider.builderpattern.main;

import com.jspider.builderpattern.builder.MobileBuilder;
import com.jspider.builderpattern.object.Mobile;

public class MobileMain {

	public static void main(String[] args) {
		
		Mobile mobile = new MobileBuilder().brand("samsung").model("s25").memory(256).colour("black").getMobile();
		System.out.println(mobile);
				
	}
}
