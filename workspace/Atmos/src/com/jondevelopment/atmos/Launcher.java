package com.jondevelopment.atmos;

import org.lwjgl.openal.AL;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import com.jondevelopment.atmos.editor.Editor;

public class Launcher {
	
	private static AppGameContainer appgc;
	private static Game game;
	
	public static void start() {
		Debug.log("Atmos is initializing...");
		try {
			// Init the App Game Container and Game object
			appgc = new AppGameContainer((game = new Game()));
			
			// Load all settings
			resize(Settings.Screen.width, Settings.Screen.height);
			appgc.setTargetFrameRate(Settings.Screen.max_fps);
			appgc.setVSync(Settings.Screen.v_sync);
			appgc.setMultiSample(Settings.Screen.anti_aliasing_level);
			
			Debug.log("Settings loaded...");
			
			appgc.setShowFPS(false);
			
			// Start the Game object
			appgc.start();
		}
		catch (SlickException e) {
			e.printStackTrace();
			System.exit(Main.ERROR);
		}
		
	}
	
	public static void resize(int width, int height) {
		try {
			if(Settings.Screen.screen_mode == Settings.Screen.screen_modes.fullscreen) {
				appgc.setDisplayMode(width, height, true);
			}
			else {
				appgc.setDisplayMode(width, height, false);
				
				// If in borderless tell opengl to not decorate the windows
				if(Settings.Screen.screen_mode == Settings.Screen.screen_modes.borderless)
					System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
			}
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
