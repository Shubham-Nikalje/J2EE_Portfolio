package jdbc3.wejm5.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		

		String className = "com.mysql.cj.jdbc.Driver"; 
		String url ="jdbc:mysql://localhost:3306/userdb";
		String userName = "root";
		String password = "root";
		String query  = "UPDATE user SET NAME='SHUBH' WHERE ID=1";
		
		Class.forName(className);
		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement statement = connection.createStatement();
		statement.execute(query);
		connection.close();
		
	}
}
	