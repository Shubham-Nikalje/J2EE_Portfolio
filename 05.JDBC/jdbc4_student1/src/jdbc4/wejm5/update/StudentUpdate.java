package jdbc4.wejm5.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentUpdate {

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
		String query = "UPDATE STUDENT1 SET NAME=? ,PHONE=?, MARK=? ,EMAIL=? WHERE ID=? ";
		
		Driver driver = new Driver();   //here we import driver for register against create (Class.forName(className));
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setLong(2, phone);
		preparedStatement.setInt(3, mark);
		preparedStatement.setString(4, email);
		preparedStatement.setInt(5, id);
		int count = preparedStatement.executeUpdate();
		
		if(count==1) {
			System.out.println("UPDATED");
		}
		else {
			System.out.println("NOT UPDATED");
		}
		
		connection.close();
		scanner.close();
	}
}
