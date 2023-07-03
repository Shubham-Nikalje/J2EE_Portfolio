package jdbc_maven_wejm10;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonMain1 {

public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
	Scanner scanner = new Scanner(System.in);
	Person person = new Person();
	PersonCRUD personCRUD = new PersonCRUD();
	boolean condition = true;
	
	do {
		System.out.println("1.INSERT DATA");
		System.out.println("2.UPDATE DATA");
		System.out.println("3.DELETE DATA");
		System.out.println("4.FETCH DATA BY ID");
		System.out.println("5.FETCH ALL DATA");
		
		System.out.println("ENTER THE CHOICE  AS PER DATA REQUIREMENT");
		int choice = scanner.nextInt();
				switch (choice) {
				case 1:
						
				{
					System.out.println("ENTER THE ID");
					int id = scanner.nextInt();
					System.out.println("ENTER THE NAME");
					String name = scanner.next();
					System.out.println("ENTER THE PHONE");
					long phone = scanner.nextLong();
					
					person.setId(id);
					person.setName(name);
					person.setPhone(phone);	
				}
				  personCRUD.savePerson(person);
					break;
					
					
				case 2:
				{
					System.out.println("ENTER THE ID");
					int id = scanner.nextInt();
					System.out.println("ENTER THE NAME");
					String name = scanner.next();
					System.out.println("ENTER THE PHONE");
					long phone = scanner.nextLong();
					
					person.setId(id);
					person.setName(name);
					person.setPhone(phone);	
					
				}
				    personCRUD.updatePerson(person);
					break;
					
				case 3:
				{
					
					System.out.println("ENTER THE ID");
					int id = scanner.nextInt();
					
					person.setId(id);
				}
				   personCRUD.deletePesrson(person);
					break;	
					
				case 4:
				{
					System.out.println("ENTER THE ID");
					int id = scanner.nextInt();
					
					person.setId(id);
					
					personCRUD.fetchPerson(id);	
				}
					break;
					
				case 5:
				{
					personCRUD.fetchAllPerson();	
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
