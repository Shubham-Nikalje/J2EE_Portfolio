
package user_maven_wejm5;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		Scanner scanner = new Scanner(System.in);
		User user = new User();
		UserCRUD userCRUD = new UserCRUD();
		boolean condition = true;

		do {
			
//			System.out.println("Enter the choice \n1. SIGN UP USER\n2. Update User\n3. Delete User\n4. Get User By Email\n5. Get All User\n6. View/Update Social Media Passwords \n7. Exit");
			
			System.out.println("Enter the choice");
			System.out.println("1.SIGN UP USER");
			System.out.println("2.FETCH ALL PASSWORD");
			System.out.println("3.LOG IN USER");
			System.out.println("4.DELETE USER");
			System.out.println("5.Get User By Email");
			System.out.println("6.Get All User");
			System.out.println("7.EXIT");

			System.out.println("ENTER THE CHOICE  AS PER DATA REQUIREMENT");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
			{
				System.out.println("Enter the Id");
				int id = scanner.nextInt();
				System.out.println("Enter the Name");
				String name = scanner.next();
				System.out.println("Enter the Email");
				String email = scanner.next();
				System.out.println("Enter the Password");
				String password = scanner.next();
				System.out.println("Enter the Address");
				String address = scanner.next();

				user.setId(id); // user.setId(scanner.nextInt());
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setAddress(address);

				userCRUD.signUpUser(user);
			}
				break;
				
			case 2:
			{
				
				System.out.println("ENTER THE EMAIL");
				String email = scanner.next();

				  user.setEmail(email);
		          userCRUD.getAllPassword(email);
		          
			}
				break;

			case 3: {
				
				System.out.println("ENTER THE EMAIL");
				String email = scanner.next();
				System.out.println("ENTER THE PASSWORD");
				String password = scanner.next();
				user.setEmail(email);
				user.setPassword(password);

				boolean result = userCRUD.logInUser(user);
				if (result) {
					System.out.println("LOG IN SUCCESFUL");
					userCRUD.getAllPassword(email);
					boolean flag = true;
					
					do{System.out.println("ENTER THE CHOICE \n1. UPDATE PASSWORD\n2. LOG OUT");
					int choice1 = scanner.nextInt();
					
						switch (choice1) {
					case 1:
						System.out.println("Enter the facebook new password");
						String facebook=scanner.next();
						user.setFacebook(facebook);
						System.out.println("Enter the whatsapp new password");
						String whatsapp=scanner.next();
						user.setWhatsapp(whatsapp);
						System.out.println("Enter the snapchat new password");
						String snapchat=scanner.next();
						user.setSnapchat(snapchat);;
						System.out.println("Enter the twitter new password");
						String twitter=scanner.next();
						user.setTwitter(twitter);;
						System.out.println("Enter the instagram new password");
						String instagram=scanner.next();
						user.setInstagram(instagram);
						
						userCRUD.updatePassword(user);
						
						break;

					default:
						flag =false;
						break;
					}
					}while(flag);
					
				} else {
					System.out.println("FAILED TO LOG IN");
					
				}
			}
				break;
				
								
//					case 2:
//					{
//						System.out.println("ENTER THE ID");
//						int id = scanner.nextInt();
//						System.out.println("ENTER THE NAME");
//						String name = scanner.next();
//						System.out.println("ENTER THE EMAIL");
//						String email = scanner.next();
//						System.out.println("ENTER THE PASSWORD");
//						String password = scanner.next();
//						
//						user.setId(id);
//						user.setName(name);
//						user.setEmail(email);
//						user.setPassword(password);
//						
//					}
//					    userCRUD.updateUser(user);
//						break;
//						
					case 4:
					{
						
						System.out.println("ENTER THE EMAIL");
						String email = scanner.next();
	
						  user.setEmail(email);
				          userCRUD.deleteUser(user);
				          
					}
						break;						
					case 5:
					{
						System.out.println("ENTER THE EMAIL");
						String email = scanner.next();
						
						  user.setEmail(email);
						
						userCRUD.fetchUser(user);	
					}
						break;					
					case 6:
					{
					      userCRUD.fetchAllUser();	
					}
						break;
						
			default:
				condition = false;
				break;
			}	
		} while (condition);
		
		scanner.close();
	}
}
