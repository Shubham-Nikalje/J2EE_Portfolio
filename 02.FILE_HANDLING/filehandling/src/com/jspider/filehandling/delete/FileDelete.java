package com.jspider.filehandling.delete;

import java.io.File;

public class FileDelete {

	public static void main(String[] args) {
		
		File file = new File("wejm5sample.txt");
		
		if(file.exists()) {
			file.delete();
			System.out.println("file delete successfuly");
		}
		else {
			System.out.println("file is not exist");
		}
	}
}
