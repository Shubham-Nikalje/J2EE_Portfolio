package maven5_jdbc_callable;

import java.util.Scanner;

public class CompanyMain {

	public static void main(String[] args) throws Exception {
		
		Company company = new Company();
		CompanyCRUD companyCRUD = new CompanyCRUD();
		boolean condition = true;
		Scanner scanner = new Scanner(System.in);
		
		do {
			
			System.out.println("Enter the choice \n1.Insert the data \n2.Update the data \n3.Delete the data \n4.Fetch the data by ussing ID \n5.Fetch the all data");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
			{
				System.out.println("enter the id");
	    		int id = scanner.nextInt();
	    		System.out.println("enter the name");
	    		String name = scanner.next();
	    		System.out.println("enter the gst");
	    		String gst = scanner.next();
	    		System.out.println("enter the address");
	    		String address = scanner.next();
	    		System.out.println("enter the phone");
	    		Long phone = scanner.nextLong();
	    		
	    		company.setId(id);
	    		company.setName(name);
	    		company.setGst(gst);
	    		company.setAddress(address);
	    		company.setPhone(phone);
	    		
	    		
	    		companyCRUD.companyInsert(company);
			}
				break;
				
			case 2:
			{
				System.out.println("enter the name");
	    		String name = scanner.next();
	    		System.out.println("enter the gst");
	    		String gst = scanner.next();
	    		System.out.println("enter the address");
	    		String address = scanner.next();
	    		System.out.println("enter the phone");
	    		Long phone = scanner.nextLong();
	    		System.out.println("enter the id");
	    		int id = scanner.nextInt();
	    		
	    		company.setName(name);
	    		company.setGst(gst);
	    		company.setAddress(address);
	    		company.setPhone(phone);
	    		company.setId(id);
	    		
	    		companyCRUD.companyUpdate(company);
			 }  
				break;
				
			case 3:
			{
	      		System.out.println("enter the id");
	      		int id = scanner.nextInt();
	      		
	      		company.setId(id);
	      		
	      		companyCRUD.companyDelete(company);
			}
				break;
				
			case 4:
			{
		      		System.out.println("enter the id");
		      		int id = scanner.nextInt();
		      		
		      		company.setId(id);
		      		
		      		companyCRUD.companyFetchById(company);
			}
		      		break;
		      		
			case 5:
			{
				companyCRUD.companyFetch(company);
			}
				
		     break;
		     
			default:
				condition=false;
				break;
			}
		} while (condition);
		
		scanner.close();
	}
}
