package com.jspider.jdbc_maven_wejm5_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class EmployeeFetch {

	public static void fetch() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the ID");
		int id = scanner.nextInt();

		String url = "jdbc:mysql://localhost:3306/employeedb?user=root&password=root";
		String query = "SELECT * FROM EMPLOYEE WHERE ID=?";

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

//		ResultSet is a return type of executeQuery so we here we resultset for assign the executeQuery() method
//		get() used to fetch the data get returntype(index/"name of colum inside String")

		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong("phone"));
			System.out.println(resultSet.getString(4));

		}

		connection.close();
		scanner.close();
	}
}
