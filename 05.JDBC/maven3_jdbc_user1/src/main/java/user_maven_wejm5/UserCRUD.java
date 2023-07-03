package user_maven_wejm5;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class UserCRUD {
	
public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
	
		FileInputStream fileInputStream = new FileInputStream("dbconfig.property");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		return connection;
	}

	public void signUpUser(User user) throws ClassNotFoundException, IOException, SQLException {
		
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO USER(ID,NAME,EMAIL,PASSWORD,ADDRESS) VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2,user.getName());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, user.getAddress());
		
		int count = preparedStatement.executeUpdate();
		
		if(count==1) {
			System.out.println("SIGH UP SUCCESSFULLY");
		}
		else {
			System.out.println("NOT SIGH UP");
		}	
		connection.close();
	}
	
	public boolean logInUser(User user) throws ClassNotFoundException, IOException, SQLException {
		
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM USER WHERE EMAIL=?");
		preparedStatement.setString(1,user.getEmail());
		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		
		while (resultSet.next()) {
			password = resultSet.getString("password");	
		}
		connection.close();
		if(password.equals(user.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void getAllPassword(String email) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM USER WHERE EMAIL=?");
		preparedStatement.setString(1,email);
		ResultSet resultSet =preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println("Facebook :" + resultSet.getString(6));
			System.out.println("WhatsApp :" + resultSet.getString(7));
			System.out.println("SnapChat :" + resultSet.getString(8));
			System.out.println("Twitter  :" + resultSet.getString(9));
			System.out.println("Instagram :" + resultSet.getString(10));
		}
		connection.close();	
	}

	public void updatePassword(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(""
				+ "UPDATE USER SET Facebook=?, WHATSAPP=?,SnapChat=?,Twitter=?,Instagram=? WHERE EMAIL=?");
		preparedStatement.setString(1, user.getFacebook());
		preparedStatement.setString(2,user.getWhatsapp());
		preparedStatement.setString(3,user.getSnapchat());
		preparedStatement.setString(4,user.getTwitter());
		preparedStatement.setString(5,user.getInstagram());
		preparedStatement.setString(6,user.getEmail());
		int count =preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("Updated");
		}else {
			System.out.println("Not Updated");
		}
		connection.close();
	}
	
//	public void updateUser(User user) throws ClassNotFoundException, IOException, SQLException {
//		
//		Connection connection = getConnection();
//		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PERSON SET NAME=? ,EMAIL=?, PASSWORD=? WHERE ID=?");
//		
//		preparedStatement.setString(1, user.getName());
//		preparedStatement.setString(2, user.getEmail());
//		preparedStatement.setString(3, user.getPassword());
//		preparedStatement.setInt(4, user.getId());
//		
//		int count = preparedStatement.executeUpdate();
//		if(count==1) {
//			System.out.println("UPDATED");
//		}
//		else {
//			System.out.println("NOT UPDATED");
//		}
//		connection.close();	
//	}
//	
	public void deleteUser(User user) throws ClassNotFoundException, IOException, SQLException {
		
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USER WHERE EMAIL=?");
		
           preparedStatement.setString(1, user.getEmail());
		
		int count = preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("DELETED");
		}
		else {
			System.out.println("NOT DELETED");
		}
		connection.close();	
	}	
      public void fetchUser(User user) throws SQLException, ClassNotFoundException, IOException {
		
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER WHERE EMAIL=?");
		preparedStatement.setString(1, user.getEmail());
		ResultSet resultSet = preparedStatement.executeQuery();
	
		 while(resultSet.next()){
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getString(5));
			System.out.println("********************************");
		}
			connection.close();
		}
	public void fetchAllUser() throws SQLException, ClassNotFoundException, IOException {
		
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER");
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getString(5));
			System.out.println("********************************");
		}
			connection.close();
		}

}
