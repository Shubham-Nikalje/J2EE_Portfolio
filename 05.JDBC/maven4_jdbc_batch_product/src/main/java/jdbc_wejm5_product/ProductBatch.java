package jdbc_wejm5_product;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//  addBatch() method is used to insert data in multiple rows INSIDE THE DATABASE(WITHOUT ddBatch() we can't insert data inside the database)
//  during creat statement along with executeBatch() method
//    return type of executeBatch() is int [] (int array)
public class ProductBatch {

	public static void main(String[] args) throws SQLException, IOException {
		
		Product product = new Product();
		product.setId(1);
		product.setName("TV");
		product.setCost(15000);
		product.setManufacturer("Sony");
		
		Product product1 = new Product();
		product1.setId(2);
		product1.setName("Mobile");
		product1.setCost(600000);
		product1.setManufacturer("Apple");
		
		Product product2 = new Product();
		product2.setId(3);
		product2.setName("AC");
		product2.setCost(40000);
		product2.setManufacturer("BlueStar");
		
		Product product3 = new Product();
		product2.setId(4);
		product2.setName("AC");
		product2.setCost(40000);
		product2.setManufacturer("BlueStar");
		
		Product product4 = new Product();
		product2.setId(5);
		product2.setName("AC");
		product2.setCost(40000);
		product2.setManufacturer("BlueStar");
		
		Product product5 = new Product();
		product2.setId(6);
		product2.setName("AC");
		product2.setCost(40000);
		product2.setManufacturer("BlueStar");
		
		List<Product> list = new ArrayList<Product>();
		list.add(product);
		list.add(product1);
		list.add(product2);
		list.add(product3);
		list.add(product4);
		list.add(product5);
		
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fileInputStream = new FileInputStream("productconf.property");
		Properties properties = new Properties();
		properties.load(fileInputStream);;
		
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user") ,properties.getProperty("password"));
		
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?,?)");
		for(Product p:list) {
			preparedStatement.setInt(1,p.getId());
			preparedStatement.setString(2,p.getName());
			preparedStatement.setInt(3,p.getCost());
			preparedStatement.setString(4,p.getManufacturer());
			preparedStatement.addBatch();
			
		}
		
		preparedStatement.executeBatch();
		System.out.println("BATCH EXECUTION DONE");
		connection.close();
		
	}
}
