package com.jspider.factorypattern.cars;

import com.jspider.factorypattern.inter.Car;

public class Endeavour implements Car{

	@Override
	public void buyCar() {
		System.out.println("bought Endeavour");		
	}

}
