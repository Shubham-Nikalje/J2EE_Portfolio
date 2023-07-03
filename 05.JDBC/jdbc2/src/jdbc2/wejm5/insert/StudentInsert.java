package jdbc2.wejm5.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		1.Load driver -
//		here we load the Driver because the taken data is static(given inside the program not by using scanner)
//		it is use for load the file(here we use MySql) by using static method forName() is present in class Class
//		forName is static method so we access it by using class name.

		Class.forName("com.mysql.cj.jdbc.Driver");

//		2.Establish connection - 
//		Connection is a interface we can't creat obj. so here use DriverManager as helper class
//		in DriverManager class there is present getConnection() is a static overload method(its return type is connection)
//		getConnection is a Static method so we access it by using class(DriverManager.getConnection)
//		getConnection(String url,String username,String pass)	

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
        DriverManager.ge
//		3.Create statement-
//		Statement is a interface we can't creat obj. for it.
//		with the help of creatStatement() we can creat obj.for Statement method present in Connection

		Statement statement = connection.createStatement();

//		4.Execute statement-
//		It is use of execute the query with help of creatStatement()
//		here 3 mothods for execute the query 
//		1.execute()-use for all statement (return type-booleans)
//		2.executeUpdate() - use for only DDL statement (return type-int)
//		3.executeQuery() - use for only DQL statement (return type-ResultSet)
//		here we used 3rd statement
//		We can insert multiple method inside database by using same statement	

		statement.execute(
				"INSERT INTO STUDENT VALUE (1,'RAM',7387573236,'PUNE'),(2,'SAN',7387573236,'MUB'),(3,'TAN',7387573236,'BAN')");

//		5.Close() - 
//		close() method used for termination of Connection

		connection.close();

	}
}
