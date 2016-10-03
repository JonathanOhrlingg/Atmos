package com.jondevelopment.atmos;

import org.lwjgl.openal.AL;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Launcher {
	
	private static AppGameContainer appgc;
	private static Game game;
	
	public static void start() {
		Debug.log("Atmos is initializing...");
		try {
			// Init the App Game Container and Game object
			appgc = new AppGameContainer((game = new Game()));
			
			// Load all settings
			if(Settings.Screen.screen_mode == Settings.Screen.screen_modes.fullscreeen) {
				appgc.setDisplayMode(Settings.Screen.width, Settings.Screen.height, true);
			}
			else {
				appgc.setDisplayMode(Settings.Screen.width, Settings.Screen.height, false);
				
				// If in borderless tell opengl to not decorate the windows
				if(Settings.Screen.screen_mode == Settings.Screen.screen_modes.borderless)
					System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
			}
			appgc.setTargetFrameRate(Settings.Screen.max_fps);
			appgc.setVSync(Settings.Screen.v_sync);
			appgc.setMultiSample(Settings.Screen.anti_aliasing_level);
			
			Debug.log("Settings loaded...");
			
			// Start the Game object
			appgc.start();
		}
		catch (SlickException e) {
			e.printStackTrace();
			System.exit(Main.ERROR);
		}
		
	}
	
	public static void stop() {
		AL.destroy();
		appgc.destroy();
	}
	
	public static Game getGame() {
		return game;
	}
	
}
