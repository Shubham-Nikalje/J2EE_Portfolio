package jdbc4.wejm5.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentInsert {

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

//		? - is a placeholder of input data from user

		String url = "jdbc:mysql://localhost:3306/student1db?user=root&password=root";
		String query = "INSERT INTO STUDENT1 VALUES (?,?,?,?,?)";
        
//		***here we resister the Driver because we will take dynamic data(by user using scanner class so register driver )
//		Driver is a class is present in mysql.jd.jdbc also Drive is an interface it is present in java.sql but here we use
//		Driver class so we create object for it and pass value inside the registerDriver() constructor.
//		Statement is handle only static query
//		PrepareStatement is handle dynamic query as well as static query
//		Dynamic query = It helps compile query without value and helps us to assign value at run time(input from user(using Scanner class))
//		In preparedStatement query compile at once.
//		PreparedStatement is an interface extends with statement 
//		PreparedStatement is child interface
//		Statement is an base(parent) iterface(PreparedStatement interface extends with Statement interface)

		Driver driver = new Driver(); // here we import Driver class present in mysql.jd.jdbc against create (Class.forName(className));
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
