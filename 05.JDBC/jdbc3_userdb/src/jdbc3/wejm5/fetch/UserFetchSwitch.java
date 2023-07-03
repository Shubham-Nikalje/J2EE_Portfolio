package jdbc3.wejm5.fetch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserFetchSwitch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String className = "com.mysql.cj.jdbc.Driver"; 
		String url ="jdbc:mysql://localhost:3306/userdb?user=root&password=root";
//		String userName = "root";
//		String password = "root";
		String query  = "SELECT * FROM USER ";
		String query1  = "SELECT * FROM USER WHERE ID=1 ";
		String query2  = "SELECT * FROM USER WHERE ID=2 ";
//		String query3  = "SELECT * FROM USER WHERE ID=3";
//		String query4  = "SELECT * FROM USER WHERE ID=4";
		
		Class.forName(className);
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		ResultSet resultSet1 = statement.executeQuery(query1);
		ResultSet resultSet2 = statement.executeQuery(query2);
//		ResultSet resultSet3 = statement.executeQuery(query);
//		ResultSet resultSet4 = statement.executeQuery(query);
		
		
		Scanner sc =  new Scanner(System.in);
				
			System.out.println("1.FETCH ALL DATA FROM TABLE");
			System.out.println("2.FETCH ALL DATA WHERE ID = 1");
			System.out.println("3.FETCH ALL DATA WHERE ID = 2");
			System.out.println("4.FETCH ALL DATA WHERE ID = 3");
			System.out.println("5.FETCH ALL DATA WHERE ID = 4");
			System.out.println("ENTER THE NUM AS PER FETCHING DATA REQ.");
			int a = sc.nextInt();

			switch (a) {
			case 1:
			{
				System.out.println("1.FETCH ALL DATA ALONG WITH ALL DETAILS");
				System.out.println("2.FETCH ALL DATA ALONG WITH ONLY ID");
				System.out.println("3.FETCH ALL DATA ALONG WITH ONLY NAME");
				System.out.println("4.FETCH ALL DATA ALONG WITH ONLY PHONE");
				System.out.println("5.FETCH ALL DATA ALONG WITH EMAIL");
				
				System.out.println("ENTER THE NUM AS PER FETCHING SUB-DATA REQ.");
				int b = sc.nextInt();
				
				switch (b) {
				case 1:
				{
				 System.out.println(resultSet.getInt(1));
			     System.out.println(resultSet.getString(2));
			     System.out.println(resultSet.getLong(3));
			     System.out.println(resultSet.getString(4));
				}
				break;
				case 2:
				{
				 System.out.println(resultSet.getInt(1));
				}
				break;
				case 3:
				{
				 System.out.println(resultSet.getString(2));
				}
				break;
				case 4:
				{
				 System.out.println(resultSet.getLong(3));
				}
				break;
				case 5:
				{
				 System.out.println(resultSet.getString(4));
				}
				break;
				default:
					System.out.println("ENTER VALID DATA");
					break;
				}
			}
			break;    // a case 1 end
			
			   case 2 :
			{
				System.out.println("1.FETCH ALL DATA ALONG WITH ALL DETAILS WHERE ID=1");
				System.out.println("2.FETCH ALL DATA ALONG WITH ONLY ID WHERE ID=1");
				System.out.println("3.FETCH ALL DATA ALONG WITH ONLY NAME WHERE ID=1");
				System.out.println("4.FETCH ALL DATA ALONG WITH ONLY PHONE WHERE ID=1");
				System.out.println("5.FETCH ALL DATA ALONG WITH EMAIL WHERE ID=1");
				
				System.out.println("ENTER THE NUM AS PER FETCHING SUB-DATA WHERE ID=1");
				int c = sc.nextInt();
				
				switch (c) {
				case 1:
				{
				 System.out.println(resultSet1.getInt(1));
			     System.out.println(resultSet1.getString(2));
			     System.out.println(resultSet1.getLong(3));
			     System.out.println(resultSet1.getString(4));
				}
				break;
				case 2:
				{
				 System.out.println(resultSet1.getInt(1));
				}
				break;
				case 3:
				{
				 System.out.println(resultSet1.getString(2));
				}
				break;
				case 4:
				{
				 System.out.println(resultSet1.getLong(3));
				}
				break;
				case 5:
				{
				 System.out.println(resultSet1.getString(4));
				}
				break;
				default:
					System.out.println("ENTER VALID DATA");
					break;
				}	
			}
			break; // a case 2 end
	
			
			   case 3 :
				{
					System.out.println("1.FETCH ALL DATA ALONG WITH ALL DETAILS WHERE ID=2");
					System.out.println("2.FETCH ALL DATA ALONG WITH ONLY ID WHERE ID=2");
					System.out.println("3.FETCH ALL DATA ALONG WITH ONLY NAME WHERE ID=2");
					System.out.println("4.FETCH ALL DATA ALONG WITH ONLY PHONE WHERE ID=2");
					System.out.println("5.FETCH ALL DATA ALONG WITH EMAIL WHERE ID=2");
					
					System.out.println("ENTER THE NUM AS PER FETCHING SUB-DATA WHERE ID=2");
					int c = sc.nextInt();
					
					switch (c) {
					case 1:
					{
					 System.out.println(resultSet2.getInt(1));
				     System.out.println(resultSet2.getString(2));
				     System.out.println(resultSet2.getLong(3));
				     System.out.println(resultSet2.getString(4));
					}
					break;
					case 2:
					{
					 System.out.println(resultSet2.getInt(1));
					}
					break;
					case 3:
					{
					 System.out.println(resultSet2.getString(2));
					}
					break;
					case 4:
					{
					 System.out.println(resultSet2.getLong(3));
					}
					break;
					case 5:
					{
					 System.out.println(resultSet2.getString(4));
					}
					break;
					default:
						System.out.println("ENTER VALID DATA");
						break;
					}	
				}
				break;  // a case 3 end
				
				
				
				
				
				default:    //of a 
					System.out.println("ENTERR VALID DATA");
					break;
				}
			sc.close();
		}
	}
