package com.jspider.filehandling.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//here scanner class use for retrieve data from file
//hasB=NestLine method used to check data is exist or not
//hasNext used to take inputs from next line
public class CharRead {

	public static void main(String[] args) {
		
		File file = new File("char.txt");
		if(file.exists()) {
			try {
				FileReader fileReader = new FileReader(file);
				System.out.println(fileReader.read());
				fileReader.close();
				
				Scanner scanner = new Scanner(file);
				while(scanner.hasNextLine()) {
					System.out.println(scanner.nextLine());
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				System.out.println("file not found");
				e.printStackTrace();
				
				
			} catch (IOException e) {
				System.out.println("enable to file read");
				e.printStackTrace();
			} 	
		}
		else {
			System.out.println("file does not exist");
		}
	}
}
