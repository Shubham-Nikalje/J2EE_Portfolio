package com.jspider.jdbc_maven_wejm5_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class EmployeeInsert {

	public static void insert() throws ClassNotFoundException, SQLException {
		
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
		String query = "INSERT INTO EMPLOYEE VALUES (?,?,?,?)";
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setLong(3, phone);
		preparedStatement.setString(4, email);
		int count = preparedStatement.executeUpdate();

		// count is for effect on rows
		if (count == 1) {
			System.out.println("INSERTED");
		} else {
			System.out.println("NOT INSERTED");
		}
		connection.close();
		scanner.close();
	}
}
