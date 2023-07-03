package com.jspider.filehandling.create;

import java.io.File;
import java.io.IOException;

//.dotx extension - 1.file is created 2.file access successfully
public class Word3 {

	public static void main(String[] args) {
		File file = new File("D:\\Q_spider\\J2EE\\02.FILE_HANDLING\\filehandling\\Word3.dotx");
		
		try {
			file.createNewFile();
			System.out.println("file is created successfully");
		} catch (IOException e) {
			System.out.println("file is not created");
		}
	}
	
	
}
