package com.jondevelopment.atmos;

public class Main {
	
	public static final int NORMAL = 0;
	public static final int ERROR = 1;
	
	public static void main(String[] args) {
		// Add a system shutdown hook to prevent unexpected shutdowns
		Runtime.getRuntime().addShutdownHook(new Thread(new OnSystemExit()));
		
		// Start the debugging tool
		Debug.init();
		// Start the game
		Launcher.start();
	}
	
}

class OnSystemExit implements Runnable {
	@Override
	public void run() {
		Debug.log("Unexpected system shutdown...");
		Launcher.stop();
	}
}
