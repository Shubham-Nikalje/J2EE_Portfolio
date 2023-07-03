package com.jspider.factorypattern.main;


import java.util.Scanner;

import com.jspider.factorypattern.cars.Endeavour;
import com.jspider.factorypattern.cars.Harrier;
import com.jspider.factorypattern.cars.HondaCity;
import com.jspider.factorypattern.cars.Nexon;
import com.jspider.factorypattern.cars.XUV700;
import com.jspider.factorypattern.inter.Car;

public class CarFactory{
	
	public static Car car;
	public static void main(String[] args) {
		
		try
		{
			factory().buyCar();
		}
		catch (NullPointerException e) {
			System.out.println("No Car Selected");
		}
		
		

	}
	private static Car factory() {
		System.out.println("Car Purchase Option \n"+" 1.Harrier \n"+" 2.XUV700 \n"+" 3.HondaCity \n"+" 4.Endeavour \n"+" 5.Nexon \n");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			car =new Harrier();
			break;
		case 2:
			car =new XUV700();
			break;
		case 3:
			car = new HondaCity();
			break;
		case 4:
			car = new Endeavour();
			break;
		case 5:
			car = new Nexon();
			break;
		default:
			System.out.println("Invalid choice");
			
		      
		}
		sc.close();
		return car;
		
		
	}
	}


