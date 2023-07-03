package maven5_jdbc_callable;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Company_Update {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the name");
		String name = scanner.next();
		System.out.println("enter the gst");
		String gst = scanner.next();
		System.out.println("enter the address");
		String address = scanner.next();
		System.out.println("enter the phone");
		Long phone = scanner.nextLong();
		System.out.println("enter the id");
		int id = scanner.nextInt();
		
		FileInputStream fileInputStream = new FileInputStream("companydb.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		CallableStatement callableStatement = connection.prepareCall("call companydb.company_update (?,?,?,?,?)");
		callableStatement.setString(1,name);
		callableStatement.setString(2,gst);
		callableStatement.setString(3,address);
		callableStatement.setLong(4,phone);
		callableStatement.setInt(5, id);
		int count = callableStatement.executeUpdate();
		
		if(count==1) {
			System.out.println("Updated sucessfully");
		}
		else {
			System.out.println("Failed to Update");
		}	
		connection.close();
		scanner.close();
	}
}
