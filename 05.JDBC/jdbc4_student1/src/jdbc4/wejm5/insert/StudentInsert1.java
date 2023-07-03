package jdbc4.wejm5.insert;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//import com.mysql.cj.jdbc.Driver;

public class StudentInsert1 {

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the ID");
		int id = scanner.nextInt();
		System.out.println("enter the name");
		String name = scanner.next();
		System.out.println("enter the phone");
		Long phone = scanner.nextLong();
		System.out.println("enter the mark");
		int mark = scanner.nextInt();
		System.out.println("enter the email");
		String email = scanner.next();

		String url = "jdbc:mysql://localhost:3306/student1db?user=root&password=root";
		String query = "INSERT INTO STUDENT1 VALUES (?,?,?,?,?)";

//		Driver is a class is present in mysql.jd.jdbc also Drive is an interface it is present in java.sql but here we use
//		Driver class so we create object for it and pass value inside the driver constructor.
//		In preparedStatement query compile at once.
//		PreparedStatement is an interface extends with statement 
//		PreparedStatement is child interface
//		Statement is an base(parent) iterface(PreparedStatement interface extends with Statement interface)

//		Driver driver = new Driver();   //here we import Driver(class) against create (Class.forName(className));
		Driver driver = new com.mysql.cj.jdbc.Driver();
//      here we did upcasting & creat object of Driver(interface) is present in
//		java.sql and pass object reff. of driver class and access the Driver class
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setLong(3, phone);
		preparedStatement.setInt(4, mark);
		preparedStatement.setString(5, email);
		int count = preparedStatement.executeUpdate();

		// count is for effect on rows
		if (count == 1) {
			System.out.println("INSERTED");
		} else {
			System.out.println("NOT INSERTED");
		}
		connection.close();
		scanner.close();
	}
}

//execute return type - booleans - true (select) & false (DQL)
//executeUpdate return type - int (no of row attended in d)  =  DML FOR (UPDATE,DELETE)
//executeQuery return type - ResultSet DQL for (select)
