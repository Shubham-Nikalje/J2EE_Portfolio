package jdbc3.wejm5.fetch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Scanner;

public class UserFetch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String className = "com.mysql.cj.jdbc.Driver"; 
		String url ="jdbc:mysql://localhost:3306/userdb?user=root&password=root";
//		String userName = "root";
//		String password = "root";
		String query  = "SELECT * FROM USER";
		
		Class.forName(className);
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
//		Scanner sc =  new Scanner(System.in);
//		System.out.println("enter the fetching data serial no...");
//		int a = sc.nextInt();
		 
//		switch (a) {
//		case 1:System.out.println(resultSet.getInt(1));
//			break;
//		case 2:System.out.println(resultSet.getString(2));
//		break;
//		case 3:System.out.println(resultSet.getLong(3));
//		break;
//		case 4:System.out.println(resultSet.getString(4));
//		break;
//		default:
//			System.out.println("ENTER VALID DATA");
//			break;	
//		}
		
		while(resultSet.next()) {
			
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));
			System.out.println(resultSet.getString(4));
			System.out.println("********************************");
		}
		
//		sc.close();
	}
}
