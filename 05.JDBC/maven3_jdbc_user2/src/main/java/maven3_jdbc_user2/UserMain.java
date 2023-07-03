package maven3_jdbc_user2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;



public class UserMain {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		Scanner scanner=new Scanner(System.in);
		User user=new User();
		UserCRUD crud=new UserCRUD();
		boolean condition=true;
		

		do
		{
			System.out.println("Enter the choice \n1. Create User\n2. Update User\n3. Delete User\n4. Get User By Email\n5. Get All User\n6. View/Update Social Media Passwords \n7. Exit");
			int choice =scanner.nextInt();
			switch (choice){
			case 1:{
				System.out.println("Enter the Id");
				int id=scanner.nextInt();
				System.out.println("Enter the Name");
				String name =scanner.next();
				System.out.println("Enter the Email");
				String email=scanner.next();
				System.out.println("Enter the Password");
				String password =scanner.next();
				System.out.println("Enter the Address");
				String address =scanner.next();
				
				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setAddress(address);
				
				crud.signUpUser(user);
			}
				break;
				
			case 2: {
				System.out.println("Enter the Id");
				int id=scanner.nextInt();
				System.out.println("Enter the Name");
				String name =scanner.next();
				System.out.println("Enter the Email");
				String email=scanner.next();
				System.out.println("Enter the Password");
				String password =scanner.next();
				System.out.println("Enter the Address");
				String address =scanner.next();
				
				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setAddress(address);
				
				crud.updateUser(user);
			}
			break;
			
			case 3: {
				System.out.println("Enter the Email you want to Delete");
				String email=scanner.next();
				user.setEmail(email);
				crud.deleteUserByEmail(user);
			}
			break;
			
			case 4:{
				System.out.println("Enter the email of the person you want to fetch");
				int id=scanner.nextInt();
				user.setId(id);
				crud.getUserByEmail(user);
			}
			break;
			case 5:{
				crud.getAllUser(user);
			}
			break;
			case 6:{
				System.out.println("Enter the Email");
				String email=scanner.next();
				System.out.println("Enter the Password");
				String password=scanner.next();
				user.setEmail(email);
				user.setPassword(password);
				if(crud.validation(user)) {
					boolean incondition=true;
					do {
					System.out.println("Enter the choice \n1. Show All Passwords \n2. Update Facebook Password \n3. Update WhatsApp Password\n4. Update Snap Chat Password\n5. Update Twitter Password\n6. Back");
					int choice2=scanner.nextInt();
					switch (choice2) {
					case 1:
						crud.getAllPassword(user);
						break;
					case 2:{
						System.out.println("Enter the new password");
						String facebook=scanner.next();
						user.setFacebook(facebook);
						crud.updateFacebook(user);
					}
					break;
					case 3:{
						System.out.println("Enter the new password");
						String whatsapp=scanner.next();
						user.setWhatsapp(whatsapp);
						crud.updateWhatsApp(user);
					}
					break;
					case 4:{
						System.out.println("Enter the new password");
						String snapchat=scanner.next();
						user.setSnapchat(snapchat);
						crud.updateSnapChat(user);
					}
					break;
					case 5:{
						System.out.println("Enter the new password");
						String twitter=scanner.next();
						user.setTwitter(twitter);
						crud.updateTwitter(user);
					}
					break;
					default: incondition=false;
						break;
					}
					} while (incondition);
				}else {
					System.out.println("Enter the Valid Email and Password");
				}
				
			}
			break;
			default:{
				System.out.println("Thank you for using our service...!!!");
				condition=false;
			}
				break;
			}	
		} while(condition);
		
		scanner.close();
		}
}
