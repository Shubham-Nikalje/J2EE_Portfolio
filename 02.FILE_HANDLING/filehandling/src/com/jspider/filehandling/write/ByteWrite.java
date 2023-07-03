package com.jspider.filehandling.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//for byte read use FileOutputStream class and write() used
//written data in to file is '-' against 45 (convert into binary language)
public class ByteWrite {

	public static void main(String[] args) {
		
		File file = new File("Byte.txt");
		if(file.exists()) {
			System.out.println("File is already exists");
		}
		else {
			try {
				file.createNewFile();
				System.out.println("file created successfully");
			} catch (IOException e) {
				System.out.println("file not created");
			}
	}
		try {
			FileOutputStream fileOutputStream= new FileOutputStream(file);
			fileOutputStream.write(45);
			System.out.println("Data written to file");
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("Unable to write into file");
		}	
}
}

