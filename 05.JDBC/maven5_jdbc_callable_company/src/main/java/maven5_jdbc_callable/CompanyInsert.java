package maven5_jdbc_callable;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class CompanyInsert {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the id");
		int id = scanner.nextInt();
		System.out.println("enter the name");
		String name = scanner.next();
		System.out.println("enter the gst");
		String gst = scanner.next();
		System.out.println("enter the address");
		String address = scanner.next();
		System.out.println("enter the phone");
		Long phone = scanner.nextLong();
		
		FileInputStream fileInputStream = new FileInputStream("companydb.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),properties.getProperty("password"));
		
		CallableStatement callableStatement = connection.prepareCall("CALL COMPANYDB.COMPANY_INSERT (?,?,?,?,?)");
		callableStatement.setInt(1,id);
		callableStatement.setString(2,name);
		callableStatement.setString(3,gst);
		callableStatement.setString(4,address);
		callableStatement.setLong(5,phone);
		int count = callableStatement.executeUpdate();
		
		if(count==1) {
			System.out.println("INSERTED SUCCESFULLY");
		}
		else {
			System.out.println("FAILED TO INSERT");
		}
		connection.close();
		scanner.close();
	}
}
