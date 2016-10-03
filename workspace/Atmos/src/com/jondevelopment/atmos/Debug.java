package com.jondevelopment.atmos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class Debug {
	
	public static boolean enable = true;
	
	private static PrintStream debugStream;
	
	public static void init() {
		try {
			File file = new File(System.getProperty("user.home") + File.separator + "AtmosLog.txt");
			boolean created = false;
			
			if(!file.exists()) {
				file.createNewFile();
				created = true;
			}
			
			debugStream = new PrintStream(file);
			
			if(created)
				log("Log file created at: " + file.getAbsolutePath());
			else
				log("Log file can be found at: " + file.getAbsolutePath());
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(Main.ERROR);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(Main.ERROR);
		}
	}
	
	public static void log(Object obj) {
		if(enable) {
			System.out.println(obj);
			debugStream.println(obj);
		}
	}
	
	public static void logError(Object obj) {
		log("Error: " + obj);
	}
	
}
