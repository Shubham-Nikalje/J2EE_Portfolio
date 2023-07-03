package com.jspider.filehandling.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//for ByteRead here used FileInputStram class & read() method used
//reading data is 45 same as written inside the ByteWrite program

public class ByteRead {

	public static void main(String[] args) {
		
		File file = new File("Byte.txt");
		if(file.exists()) {
			
			try {
				FileInputStream fileInputStream =  new FileInputStream(file);
				System.out.println(fileInputStream.read());
				fileInputStream.close();
			} catch (FileNotFoundException e) {
				System.out.println("file is not found");
			} catch (IOException e) {
				System.out.println("enable to read file");
			}
		}
		else {
			System.out.println("file does not exist");
		}
	}
}
//here we want to read already created file Byty.text(it mension in same object) there we write 45
//so here get output 45
