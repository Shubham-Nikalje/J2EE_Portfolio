package maven5_jdbc_emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpOperation {

	 private static Connection connection;
	 private static Statement statement;
	 private static PreparedStatement preparedStatement;
	 private static String query;
	 private static final String dburl="jdbc:mysql://localhost:3306/empdb";
	 private static final String driverPath ="com.mysql.cj.jdbc.Driver";
	 private static final String user = "root";
	 private static final String password = "root";
	 private static ResultSet resultSet;
	 private static int result;
	 private static Scanner scanner = new Scanner(System.in);
	 
	 public static void main(String[] args) {
		
		 try {
			Class.forName(driverPath);
			connection = DriverManager.getConnection(dburl,user,password);
			 statement = connection.createStatement();
			 
			 //1. creat emp table
			 
//	         query = "create table emp1 (empno int(4) primary key, " + " ename varchar(45),job varchar(45), sal int(10))";
//	     
//	         result = statement.executeUpdate(query);
//	         
//	         System.out.println("Table created succesfully..!!");
//	         result =0;
//			
			//2.insert 5 records
	         
	         query = "insert into emp1 values(?,?,?,?)";
	         preparedStatement = connection.prepareStatement(query);
	         
	         
	         for (int i = 1; i <=5; i++) {
	        	 
			 System.out.println("enter the empno record for "+i);
	         preparedStatement.setInt(1,scanner.nextInt());
	         System.out.println("enter the ename record for "+i);
	         preparedStatement.setString(2,scanner.next());
	         System.out.println("enter the job record for "+i);
	         preparedStatement.setString(3,scanner.next());
	         System.out.println("enter the sal record for "+i);
	         preparedStatement.setInt(4,scanner.nextInt());
	         
	         result = result + preparedStatement.executeUpdate();
				
			}
	         
	         System.out.println(result + "record inserted succesfully..!!");
	         result=0;
	         
	         //3.display all records
	         
	         query = "select * from emp1";
	         resultSet = statement.executeQuery(query);
	         while(resultSet.next()) {
	        	 System.out.println(resultSet.getInt(1)+" | "+
	             resultSet.getString(2)+" | "+resultSet.getString(3)+" | "+resultSet.getString(4));
	         }
	         
	         //4. update 1 record
	         
	         query = "update emp1 set job =? where empno=?";
	         preparedStatement = connection.prepareStatement(query);
	         System.out.println("enter new value for job");
	         preparedStatement.setString(1,scanner.next());
	         System.out.println("enter the empno");
	         preparedStatement.setInt(2,scanner.nextInt());
	         
	         result = preparedStatement.executeUpdate();
	         System.out.println(result+" record updated succesfully..!!");
	         result=0;
	         
	         //5.display all records
	         
	         query = "select * from emp1";
	         resultSet = statement.executeQuery(query);
	         while(resultSet.next()) {
	        	 System.out.println(resultSet.getInt(1)+" | "+
	             resultSet.getString(2)+" | "+resultSet.getString(3)+" | "+resultSet.getString(4));
	         }
	         
	         //6.delete 1 record
	         
	         query= "delete from emp1 where empno=?";
	         preparedStatement = connection.prepareStatement(query);
	         System.out.println("enter empno to delete");
	         preparedStatement.setInt(1,scanner.nextInt());
	         result = preparedStatement.executeUpdate();
	         System.out.println(result+" record deleted succesfully..!!");
	         result=0;
	         
	         //7.display all records
	         
	         query = "select * from emp1";
	         resultSet = statement.executeQuery(query);
	         while(resultSet.next()) {
	        	 System.out.println(resultSet.getInt(1)+" | "+
	             resultSet.getString(2)+" | "+resultSet.getString(3)+" | "+resultSet.getString(4));
	         }
	             
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			  try {
				  if(connection!=null) {
					connection.close();
				} 
				  if(statement!=null) {
						statement.close();
					} 
				  if(preparedStatement!=null) {
						preparedStatement.close();
					} 
				  if(resultSet!=null) {
					    resultSet.close();
					} 
			  }
				  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 }	 	
}