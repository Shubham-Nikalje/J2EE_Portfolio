package jdbc2.wejm5.fetch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentFetch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String className = "com.mysql.cj.jdbc.Driver"; 
		String url ="jdbc:mysql://localhost:3306/studentdb?user=root&password=root";
//		String userName = "root";
//		String password = "root";
		String query  = "SELECT * FROM STUDENT";
		
//	     for select use executeQuery and for other use executeUpdate
//		for fetching data use the get keyword along with query ans variable
//		return type of executeQuery(select *) is resultSet
//		here while used for a check availibilty of data by using next() method
//		here return type of next() boolean
//		here get() method use for fetching the data from database along with column name
		
		
		
		Class.forName(className);
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));
			System.out.println(resultSet.getString(4));
			System.out.println("********************************");
		}
	}
}
