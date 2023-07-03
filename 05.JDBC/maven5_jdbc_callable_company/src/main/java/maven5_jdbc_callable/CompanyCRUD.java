package maven5_jdbc_callable;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class CompanyCRUD {
	
	   public Connection getConnection() throws Exception {
		   
		   FileInputStream fileInputStream = new FileInputStream("companydb.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			Class.forName(properties.getProperty("className"));
			Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),properties.getProperty("password"));
		    return connection;
	   }
	
		public void companyInsert(Company company) throws Exception {
		
			Connection connection=getConnection();
//			call procedure_name() is used as query bcz. we write query inside the same method(store procedure)
			CallableStatement callableStatement = connection.prepareCall("CALL COMPANYDB.COMPANY_INSERT (?,?,?,?,?)");
			callableStatement.setInt(1,company.getId());
			callableStatement.setString(2,company.getName());
			callableStatement.setString(3,company.getGst());
			callableStatement.setString(4,company.getAddress());
			callableStatement.setLong(5,company.getPhone());
			int count = callableStatement.executeUpdate();
			
			if(count==1) {
				System.out.println("INSERTED SUCCESFULLY");
			}
			else {
				System.out.println("FAILED TO INSERT");
			}
			connection.close();
		}

        public void companyUpdate(Company company) throws Exception {
        	
    		Connection connection = getConnection();
    		CallableStatement callableStatement = connection.prepareCall("call companydb.company_update (?,?,?,?,?)");
    		callableStatement.setString(1,company.getName());
    		callableStatement.setString(2,company.getGst());
    		callableStatement.setString(3,company.getAddress());
    		callableStatement.setLong(4,company.getPhone());
    		callableStatement.setInt(5,company.getId());
    		int count = callableStatement.executeUpdate();
    		
    		if(count==1) {
    			System.out.println("Updated sucessfully");
    		}
    		else {
    			System.out.println("Failed to Update");
    		}	
    		connection.close();
    	}
  
      
          public void companyDelete(Company company) throws Exception {
        	  
      		Connection connection = getConnection();
      		CallableStatement callableStatement = connection.prepareCall("CALL COMPANYDB.COMPANY_DELETE(?)");
      		callableStatement.setInt(1,company.getId());
      		
      		int count = callableStatement.executeUpdate();
      		if(count==1) {
      			System.out.println("DELETED SUCCESFULLY");
      		}
      		else {
      			System.out.println("FAILED TO DELETE");
      		}
      		
      		connection.close();
}
          public void companyFetchById(Company company) throws Exception {
        	
      		Connection connection = getConnection();
      		CallableStatement callableStatement = connection.prepareCall("CALL COMPANYDB.COMPANY_FETCHBYID(?)");
      		callableStatement.setInt(1, company.getId());
      	    ResultSet resultSet = callableStatement.executeQuery();
      	    while (resultSet.next()) {
      			System.out.println("Company ID: "+resultSet.getInt(1));
      			System.out.println("Company Name: "+resultSet.getString(2));
      			System.out.println("Company GST: "+resultSet.getString(3));
      			System.out.println("Company Address: "+resultSet.getString(4));
      			System.out.println("Company Phone: "+resultSet.getLong(5));
      		
      		}
      	    connection.close();
          }
          
          public void companyFetch(Company company) throws Exception {
      		
      		Connection connection = getConnection();
      		CallableStatement callableStatement = connection.prepareCall("CALL COMPANYDB.COMPANY_FETCH");
      	    ResultSet resultSet = callableStatement.executeQuery();
      	    while (resultSet.next()) {
      			System.out.println("Company ID: "+resultSet.getInt(1));
      			System.out.println("Company Name: "+resultSet.getString(2));
      			System.out.println("Company GST: "+resultSet.getString(3));
      			System.out.println("Company Address: "+resultSet.getString(4));
      			System.out.println("Company Phone: "+resultSet.getLong(5));
      		
      		}
      	    connection.close();
          }
}