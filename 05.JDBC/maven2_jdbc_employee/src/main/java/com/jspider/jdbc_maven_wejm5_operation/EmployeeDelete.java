package com.jspider.jdbc_maven_wejm5_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class EmployeeDelete {

	public static void delete() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the ID");
		int id = scanner.nextInt();

		String url = "jdbc:mysql://localhost:3306/employeedb?user=root&password=root";
		String query = "DELETE FROM EMPLOYEE WHERE ID=?";

		Driver driver = new Driver(); // here we import driver against create (Class.forName(className));
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setInt(1, id);
		int count = preparedStatement.executeUpdate();

		if (count == 1) {
			System.out.println("DELETED");
		} else {
			System.out.println("NOT DELETED");
		}

		connection.close();
		scanner.close();
	}
}
