package com.jspider.filehandling.create;

import java.io.File;
import java.io.IOException;

//exist()- exist() is non-static method present in File class it is used to check file is exist ya not
// return type of exist() id Booleans
public class FileCreate3 {

	public static void main(String[] args) {
		File file = new File("D:\\Q_spider\\J2EE\\02.FILE_HANDLING\\filehandling\\filecreated3.txt");
		
		if(file.exists()) {
			System.out.println("file is already exist");
		}
		else {
			try {
				file.createNewFile();
				System.out.println("file is succesfuly created");
			} catch (IOException e) {
				System.out.println("file is not created");
			}
			}
	}
}
