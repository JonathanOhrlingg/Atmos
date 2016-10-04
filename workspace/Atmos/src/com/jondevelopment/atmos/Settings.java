package com.jondevelopment.atmos;

import java.io.File;
import java.io.IOException;

public class Settings {
	
	public static final String PATH = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "AtmosSettings.properties";
	
	public static void load() {
		try {
			File settingsFile = new File(PATH);
			if(!settingsFile.exists()) {
				settingsFile.createNewFile();
				setDefaults();
				writeSettings();
				load();
			}
			else {
				String[] text = Loader.loadAbsoluteTextFile(settingsFile.getAbsolutePath());
				for(String s : text) {
					String c = s.split(":")[1];
					if(s.startsWith("width:")) {
						Screen.width = Integer.parseInt(c);
					}
					else if(s.startsWith("height:")) {
						Screen.height = Integer.parseInt(c);
					}
					else if(s.startsWith("screen_mode:")) {
						Screen.screen_mode = Screen.screen_modes.valueOf(c);
					}
					else if(s.startsWith("v_sync:")) {
						Screen.v_sync = Boolean.parseBoolean(c);
					}
					else if(s.startsWith("max_fps:")) {
						Screen.max_fps = Integer.parseInt(c);
					}
					else if(s.startsWith("anti_aliasing_level:")) {
						Screen.anti_aliasing_level = Integer.parseInt(c);
					}
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeSettings() {
		StringBuilder x = new StringBuilder();
		x.append("width:" + Screen.width + System.lineSeparator());
		x.append("height:" + Screen.height + System.lineSeparator());
		x.append("screen_mode:" + Screen.screen_mode + System.lineSeparator());
		x.append("v_sync:" + Screen.v_sync + System.lineSeparator());
		x.append("max_fps:" + Screen.max_fps + System.lineSeparator());
		x.append("anti_aliasing_level:" + Screen.anti_aliasing_level + System.lineSeparator());
		Loader.writeAbsoluteTextFile(PATH, x.toString());
	}
	
	public static void setDefaults() {
		Screen.width = 1600;
		Screen.height = 900;
		Screen.screen_mode = Screen.screen_modes.windowed;
		Screen.v_sync = false;
		Screen.max_fps = 120;
		Screen.anti_aliasing_level = 8;
	}
	
	public static class Screen {
		
		public static enum screen_modes {
			windowed,
			fullscreen,
			borderless
		}
		
		public static int width;
		public static int height;
		
		public static screen_modes screen_mode;
		
		public static boolean v_sync;
		public static int max_fps;
		public static int anti_aliasing_level;
		
	}
	
	public static class Audio {
		
	}
	
	public static class Controls {
		
	}
	
}
