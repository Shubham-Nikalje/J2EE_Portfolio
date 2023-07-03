package jdbc_maven_wejm10;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class PersonCRUD {

	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

//		fileinput use for reading file and propety(class) obj. for access the data inside the property file
		FileInputStream fileInputStream = new FileInputStream("dbconfig.property");
		Properties properties = new Properties();
		properties.load(fileInputStream);

//		here load the driver (access the classname by using property class)
		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));
		return connection;
	}

	public void savePerson(Person person) throws ClassNotFoundException, IOException, SQLException {

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?)");
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3, person.getPhone());

		int count = preparedStatement.executeUpdate();

		if (count == 1) {
			System.out.println("INSERTED");
		} else {
			System.out.println("NOT INSERTED");
		}

		connection.close();
	}

	public void updatePerson(Person person) throws ClassNotFoundException, IOException, SQLException {

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE PERSON SET NAME=? ,PHONE=? WHERE ID=?");

		preparedStatement.setString(1, person.getName());
		preparedStatement.setLong(2, person.getPhone());
		preparedStatement.setInt(3, person.getId());

		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("UPDATED");
		} else {
			System.out.println("NOT UPDATED");
		}
		connection.close();
	}

	public void deletePesrson(Person person) throws ClassNotFoundException, IOException, SQLException {

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PERSON WHERE ID=?");

		preparedStatement.setInt(1, person.getId());

		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("DELETED");
		} else {
			System.out.println("NOT DELETED");
		}
		connection.close();
	}

	public void fetchPerson(int id) throws SQLException, ClassNotFoundException, IOException {

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERSON WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));
			System.out.println("********************************");
		}
		connection.close();
	}

	public void fetchAllPerson() throws SQLException, ClassNotFoundException, IOException {

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERSON");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));
			System.out.println("********************************");
		}
		connection.close();
	}
}
