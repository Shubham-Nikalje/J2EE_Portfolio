package maven5_jdbc_emp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class EmpCrud {
	
		public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

//			fileinput use for reading file and propety(class) obj. for access the data inside the property file
			FileInputStream fileInputStream = new FileInputStream("empdb.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);

//			here load the driver (access the classname by using property class)
			Class.forName(properties.getProperty("className"));
			Connection connection = DriverManager.getConnection(properties.getProperty("url"),
					properties.getProperty("user"), properties.getProperty("password"));
			return connection;
		}
		
		public void saveEmp(Emp emp) throws ClassNotFoundException, IOException, SQLException {

			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO EMP VALUES(?,?,?,?)");
			preparedStatement.setInt(1, emp.getEmpno());
			preparedStatement.setString(2, emp.getEname());
			preparedStatement.setString(3, emp.getJob());
			preparedStatement.setString(4, emp.getSal());
			

			int count = preparedStatement.executeUpdate();

			if (count == 1) {
				System.out.println("INSERTED");
			} else {
				System.out.println("NOT INSERTED");
			}

			connection.close();
		}
		
		public void updateEmp(Emp emp) throws ClassNotFoundException, IOException, SQLException {

			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE EMP SET ENAME=? ,JOB=?, SAL=? WHERE EMPNO=?");

			preparedStatement.setString(1, emp.getEname());
			preparedStatement.setString(2, emp.getJob());
			preparedStatement.setString(3, emp.getSal());
			preparedStatement.setInt(4, emp.getEmpno());

			int count = preparedStatement.executeUpdate();
			if (count == 1) {
				System.out.println("UPDATED");
			} else {
				System.out.println("NOT UPDATED");
			}
			connection.close();
		}
		
		public void deleteEmp(Emp emp) throws ClassNotFoundException, IOException, SQLException {

			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM EMP WHERE EMPNO=?");

			preparedStatement.setInt(1, emp.getEmpno());
			
			int count = preparedStatement.executeUpdate();
			if (count == 1) {
				System.out.println("DELETED");
			} else {
				System.out.println("NOT DELETED");
			}
			connection.close();
		}	
		
		public void fetchEmp(int empno) throws SQLException, ClassNotFoundException, IOException {

			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMP WHERE EMPNO=?");
			preparedStatement.setInt(1,empno);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
				System.out.println("********************************");
			}
			connection.close();
		}

		public void fetchAllEmp() throws SQLException, ClassNotFoundException, IOException {

			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMP");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
				System.out.println("********************************");
			}
			connection.close();
		}

	}

