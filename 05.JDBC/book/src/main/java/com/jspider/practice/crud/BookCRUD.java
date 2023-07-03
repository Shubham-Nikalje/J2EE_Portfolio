package com.jspider.practice.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class BookCRUD {
	
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static final String dburl = "jdbc:mysql://localhost:3306/bookdb";
	private static final String driverpath = "com.mysql.cj.jdbc.Driver";
	private static final String username = "root";
	private static final String password = "root";
	private static ResultSet resultSet;
	private static int result;
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[]args) throws Exception {
		
		try {
		Class.forName(driverpath);
		Connection connection = DriverManager.getConnection(dburl, username, password);
		
		//add book
		
		 query = "INSERT INTO BOOK VALUES(?,?,?,?)";
		 preparedStatement = connection.prepareStatement(query);
		 
		 for(int i=1;i<=1;i++) {
			System.out.println("eneter the id of book "+i);
			preparedStatement.setInt(1,scanner.nextInt());
			System.out.println("enter the name of book "+i);
			preparedStatement.setString(2,scanner.next());
			System.out.println("enter the author of book "+i);
			preparedStatement.setString(3,scanner.next());
			System.out.println("eneter the price of book "+i);
			preparedStatement.setInt(4,scanner.nextInt());
			
			result=result+preparedStatement.executeUpdate();
			
		 }
		 System.out.println(result+" record inserted succesfuly");
		 result=0;
		 
		 
		 //display all
		 query = "select * from book";
		 resultSet = preparedStatement.executeQuery(query);
		 while(resultSet.next()) {
			 System.out.println(resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3)+" | "+resultSet.getInt(4));
		 }
		 
		 
		 //update book
		 
		 System.out.println("for updation");
		 query= "update book set name=?, author=?, price=? where id=?";
		 preparedStatement = connection.prepareStatement(query);
		System.out.println("enter the book name");
		preparedStatement.setString(1,scanner.next());
		System.out.println("enter the author name");
		preparedStatement.setString(2,scanner.next());
		System.out.println("enter the book price");
		preparedStatement.setInt(3,scanner.nextInt());
		System.out.println("enter the book id");
		preparedStatement.setInt(4,scanner.nextInt());

		 		 
		 result = preparedStatement.executeUpdate();
		 System.out.println(result+" updated succesfuly");
		 result=0;
		 
		//display all
		 query = "select * from book";
		 resultSet = preparedStatement.executeQuery(query);
		 while(resultSet.next()) {
			 System.out.println(resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3)+" | "+resultSet.getInt(4));
		 }
		 
		 
		 //delete one data
		 query="delete from book where id=?";
		 preparedStatement=connection.prepareStatement(query);
		 System.out.println("enter the book id");
		 preparedStatement.setInt(1,scanner.nextInt());
		 result = preparedStatement.executeUpdate();
		 System.out.println(result+" deleted succesfully");
		 result=0;
		}catch (Exception e) {
		e.printStackTrace();
		}finally {
			if(connection!=null) {
				connection.close();
			}
			if(statement!=null) {
				statement.close();
			}
			if(preparedStatement!=null) {
				preparedStatement.close();
			}
			if(resultSet!=null) {
				resultSet.close();
			}
		}	 
		
	}

}
