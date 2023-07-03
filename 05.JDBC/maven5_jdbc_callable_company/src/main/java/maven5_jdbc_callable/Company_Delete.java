package maven5_jdbc_callable;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Company_Delete {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the id");
		int id = scanner.nextInt();
		
		FileInputStream fileInputStream = new FileInputStream("companydb.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		CallableStatement callableStatement = connection.prepareCall("CALL COMPANYDB.COMPANY_DELETE(?)");
		callableStatement.setInt(1, id);
		
		int count = callableStatement.executeUpdate();
		if(count==1) {
			System.out.println("DELETED SUCCESFULLY");
		}
		else {
			System.out.println("FAILED TO DELETE");
		}
		
		connection.close();
		scanner.close();
	}
}
