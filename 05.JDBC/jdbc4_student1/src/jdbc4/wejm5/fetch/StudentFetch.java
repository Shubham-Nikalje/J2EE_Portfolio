package jdbc4.wejm5.fetch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentFetch {

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the ID");
		int id = scanner.nextInt();

		String url = "jdbc:mysql://localhost:3306/student1db?user=root&password=root";
		String query = "SELECT * FROM STUDENT1 WHERE ID=?";

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

//		ResultSet is a return type of executeQuery so we here we resultset for assign the executeQuery() method
//		get() used to fetch the data get return type(index/"name of column inside String")

		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong("phone"));
			System.out.println(resultSet.getInt(4));
			System.out.println(resultSet.getString(5));

		}

		connection.close();
		scanner.close();
	}
}
