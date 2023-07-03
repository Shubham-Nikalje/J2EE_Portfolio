package com.jspider.filehandling.create;

import java.io.File;
import java.io.IOException;

//default path - only given filename and file extension
public class FileCreate1 {

	public static void main(String[] args) {
		
		File file = new File("filecreated1.txt");
		//enter here file.createNewFile exception get use try catch suggestion
		try {
			file.createNewFile();
			System.out.println("file is created succesfully");
		} catch (IOException e) {
			System.out.println("file is not created");
		}
				
	}
}
