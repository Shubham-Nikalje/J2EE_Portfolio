package com.jspider.jdbc_maven_wejm5_main;

import java.sql.SQLException;
import java.util.Scanner;

import com.jspider.jdbc_maven_wejm5_operation.EmployeeDelete;
import com.jspider.jdbc_maven_wejm5_operation.EmployeeFetch;
import com.jspider.jdbc_maven_wejm5_operation.EmployeeInsert;
import com.jspider.jdbc_maven_wejm5_operation.EmployeeUpdate;



public class EmployeeMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1.INSERT DATA");
		System.out.println("2.UPDATE DATA");
		System.out.println("3.DELETE DATA");
		System.out.println("4.FETCH DATA");
		
		System.out.println("ENTER THE NO. AS PER DATA REQUIREMENT");
		int sc = scanner.nextInt();
		
		switch (sc) {
		case 1:
		{
			EmployeeInsert.insert();
		}
			break;
		case 2:
		{
			EmployeeUpdate.update();
		}
			break;
		case 3:
		{
			EmployeeDelete.delete();
		}
			break;
		case 4:
		{
			EmployeeFetch.fetch();
		}
			break;

		default:
			break;
		}
		
		scanner.close();
	}
}
