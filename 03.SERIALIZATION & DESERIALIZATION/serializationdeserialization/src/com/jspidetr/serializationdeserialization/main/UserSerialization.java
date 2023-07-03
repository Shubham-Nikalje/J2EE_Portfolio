package com.jspidetr.serializationdeserialization.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.jspidetr.serializationdeserialization.object.User;

public class UserSerialization {
	public static void main(String[] args) {
		
		try {
			File file = new File("User.txt");
			if(file.exists()) {
				System.out.println("FILE IS ALREADY EXIST");
			}
			else {
				file.createNewFile();
				System.out.println("FILE IS CREATED SUCCESFULY");
			}
			
			User user = new User();
			user.setId(1);
			user.setName("shubham");
			user.setUsername("shubh@12");
			user.setPassword("san123");
			
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectInputStream = new ObjectOutputStream(fileOutputStream);
			objectInputStream.writeObject(user);
			System.out.println("object written to file");
			
			fileOutputStream.close();
			objectInputStream.close();	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
