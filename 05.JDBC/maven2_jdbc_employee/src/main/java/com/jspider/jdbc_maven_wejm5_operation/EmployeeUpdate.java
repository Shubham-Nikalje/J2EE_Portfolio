package com.jspider.jdbc_maven_wejm5_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class EmployeeUpdate {

	public static void update() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the ID");
		int id = scanner.nextInt();
		System.out.println("enter the name");
		String name = scanner.next();
		System.out.println("enter the phone");
		Long phone = scanner.nextLong();
		System.out.println("enter the email");
		String email = scanner.next();
		
		String url = "jdbc:mysql://localhost:3306/employeedb?user=root&password=root";
		String query = "UPDATE EMPLOYEE SET NAME=? ,PHONE=?,EMAIL=? WHERE ID=? ";
		
		Driver driver = new Driver();   //here we import driver against create (Class.forName(className));
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setLong(2, phone);
		preparedStatement.setString(3, email);
		preparedStatement.setInt(4, id);
		int count = preparedStatement.executeUpdate();
		
		if(count==1) {
			System.out.println("UPDATED");
		}
		else {
			System.out.println("NOT UPDATED");
		}
		
		connection.close();
		scanner.close();
	}
}
