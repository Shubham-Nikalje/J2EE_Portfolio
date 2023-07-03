package com.jspider.filehandling.create;

import java.io.File;
import java.io.IOException;

public class FileCreate2 {

	
	//createNewFile() is non-static method present in File class it creat new file one given path
	public static void main(String[] args) {
		File file = new File("D:\\Q_spider\\J2EE\\02.FILE_HANDLING\\filehandling\\filecreated2.txt");
		try {
			 
			file.createNewFile();
			System.out.println("file created successfuly");
		}catch (IOException e) {
			System.out.println("file not created successfully");
		}
	}
}
