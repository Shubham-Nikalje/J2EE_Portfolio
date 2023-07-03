package com.jspider.filehandling.info;

import java.io.File;
import java.io.IOException;

public class FileInfo {

	public static void main(String[] args) {
		
		File file = new File("wejm5.txt");
		if(file.exists()) {
			System.out.println("file is already exist");
		}
		else {
			try {
				file.createNewFile();
				System.out.println("file is created succesfuly");
			} catch (IOException e) {
				System.out.println("file is not created");
			}
		}
		
		System.out.println("name of file: "+file.getName());
		System.out.println("path of file: "+file.getAbsolutePath());
		System.out.println("length of file: "+file.length());
		if(file.canRead()) {
			System.out.println("file is redable");
		}
		else {
			System.out.println("file is not redable");
		}
		if(file.canWrite()) {
			System.out.println("file is writable");
		}
		else {
			System.out.println("file is not writable");
		}
		if(file.canExecute()) {
			System.out.println("file is executable");
		}
		else {
			System.out.println("file is not executable");
		}
	}
}
