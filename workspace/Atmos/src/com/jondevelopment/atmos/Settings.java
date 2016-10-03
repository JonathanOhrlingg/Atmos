package com.jondevelopment.atmos;

public class Settings {
	
	public static class Screen {
		
		public static enum screen_modes {
			windowed,
			fullscreeen,
			borderless
		}
		
		public static int width = 1600;
		public static int height = 900;
		
		public static screen_modes screen_mode = screen_modes.windowed;
		
		public static boolean v_sync = false;
		public static int max_fps = 120;
		public static int anti_aliasing_level = 8;
		
	}
	
	public static class Audio {
		
	}
	
	public static class Controls {
		
	}
	
}
