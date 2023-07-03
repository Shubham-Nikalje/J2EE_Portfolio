package com.jspider.filehandling.write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//here we used FileWritten class and write()
//inside created file write same as given input is "This is data from file"
public class CharWrite {
 public static void main(String[] args) {
	File file = new File("char.txt");
	if(file.exists()) {
		System.out.println("file already exist");
	}
	else {
		try {
			file.createNewFile();
			System.out.println("file is created");
		} catch (IOException e) {
			System.out.println("file is not created");
			e.printStackTrace();
		}
	}
	try {
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write("This is data from program");
		System.out.println("data written to file");
		fileWriter.close();
	} catch (IOException e) {
		System.out.println("data not able to written in file");
		e.printStackTrace();
	}
			
}
}
