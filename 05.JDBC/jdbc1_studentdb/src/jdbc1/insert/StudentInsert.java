package jdbc1.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		        //1. load or register the driver here we load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//2. establish connection
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
				
				//3.Create statement
				Statement statement = connection.createStatement();
				
				//4.execute Statement
				statement.execute("INSERT INTO STUDENT VALUE(1,'RAM',7387573236,'PUNE')");
				
				 
				//5.CLOSE CONNECTION
				connection.close();
	}
}
