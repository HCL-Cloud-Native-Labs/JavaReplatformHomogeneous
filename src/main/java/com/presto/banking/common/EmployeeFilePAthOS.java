package com.presto.banking.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class EmployeeFilePAthOS {


	public static String fileseparator() throws IOException  {
		
		OutputStream os = new FileOutputStream(new File("D:/Mani/Migration/Mani/read.txt"));
		File file = new File("D://users//Migration//users//read.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null)
			System.out.println(st);
		return st;
		
	}

}


