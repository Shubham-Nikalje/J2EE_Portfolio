package maven3_jdbc_user2;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class UserCRUD {
	public Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
		FileInputStream fileInputStream=new FileInputStream("dbconfi.property");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"),properties.getProperty("password"));
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
		
		int count =preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("Inserted");
		}else {
			System.out.println("Not Inserted");
		}
		connection.close();
	}
	
	public void updateUser(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(""
				+ "UPDATE USER SET ID=?, NAME=?,PASSWORD=?, ADDRESS=? WHERE EMAIL=?");
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2,user.getName());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setString(4, user.getAddress());
		preparedStatement.setString(5, user.getEmail());
		int count =preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("Updated");
		}else {
			System.out.println("Not Updated");
		}
		connection.close();
		
	}
	
	public void deleteUserByEmail(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM USER WHERE EMAIL=?");
		
		preparedStatement.setString(1, user.getEmail());
		int count =preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("Deleted");
		}else {
			System.out.println("Not Deleted");
		}	
		connection.close();
		
	}
	
	public void getUserByEmail(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM USER WHERE EMAIL=?");
		
		preparedStatement.setString(1, user.getEmail());
		ResultSet resultSet =preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getString(5));
		}
		connection.close();
		
	}
	
	public void getAllUser(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM USER");
	
		ResultSet resultSet =preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getString(5));
		}
		connection.close();
		
	}
	
	public void getAllPassword(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM USER WHERE EMAIL=? AND PASSWORD=?");
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getPassword());
		ResultSet resultSet =preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println("Facebook :"+resultSet.getString(6));
			System.out.println("WhatsApp :"+resultSet.getString(7));
			System.out.println("SnapChat :"+resultSet.getString(8));
			System.out.println("Twitter  :"+resultSet.getString(9));
		}
		connection.close();
		
	}
	public boolean validation(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM USER WHERE EMAIL=? AND PASSWORD=?");
		
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getPassword());
		ResultSet resultSet =preparedStatement.executeQuery();
		boolean result=false;
		while(resultSet.next()) {
			result =true;
		}
		 connection.close();
		 return result;
		}
	public void updateFacebook(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(""
				+ "UPDATE USER SET FACEBOOK=? WHERE EMAIL=?");
		preparedStatement.setString(1, user.getFacebook());
		preparedStatement.setString(2,user.getEmail());
		int count =preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("Updated");
		}else {
			System.out.println("Not Updated");
		}
		connection.close();
		
	}
	public void updateWhatsApp(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(""
				+ "UPDATE USER SET WHATSAPP=?, WHERE EMAIL=?");
		preparedStatement.setString(1, user.getWhatsapp());
		preparedStatement.setString(2,user.getEmail());
		int count =preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("Updated");
		}else {
			System.out.println("Not Updated");
		}
		connection.close();
		
	}
	public void updateSnapChat(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(""
				+ "UPDATE USER SET SNAPCHAT=?, WHERE EMAIL=?");
		preparedStatement.setString(1, user.getSnapchat());
		preparedStatement.setString(2,user.getEmail());
		int count =preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("Updated");
		}else {
			System.out.println("Not Updated");
		}
		connection.close();
		
	}
	public void updateTwitter(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(""
				+ "UPDATE USER SET TWITTER=?, WHERE EMAIL=?");
		preparedStatement.setString(1, user.getTwitter());
		preparedStatement.setString(2,user.getEmail());
		int count =preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("Updated");
		}else {
			System.out.println("Not Updated");
		}
		connection.close();
		
	}
}
	
	
