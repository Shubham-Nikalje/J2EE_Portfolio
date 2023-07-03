package jdbc3.wejm5.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		

		String className = "com.mysql.cj.jdbc.Driver"; 
		String url ="jdbc:mysql://localhost:3306/userdb";
		String userName = "root";
		String password = "root";
		String query  = "INSERT INTO USER VALUE (1,'SHUBHAM',7387573236,'shubhamnikalje12@gmail.com',12345,'PUNE'),(2,'MAHESH',7020551335,'mahesh.wagh27@gmail.com',54321,'SAMBHAJINAGAR'),(3,'ABHISHEK',7448057070,'bhosaleabhishek7070@gmail.com',67891,'BARAMATI')";
		
		Class.forName(className);
		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement statement = connection.createStatement();
		statement.execute(query);
		connection.close();
		
	}
}
