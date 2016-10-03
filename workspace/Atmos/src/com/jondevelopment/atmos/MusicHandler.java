package com.jondevelopment.atmos;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class MusicHandler {
	
	public static final int MAIN_MENU = 0;
	
	private static Music currentMusic;
	
	public static void start(int id) {
		if(currentMusic != null) {
			currentMusic.stop();
		}
		try {
			currentMusic = new Music(getPath(id), true);
			currentMusic.play();
		}
		catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	private static String getPath(int id) {
		if(id == MAIN_MENU) {
			return "music/ambient_music.ogg";
		}
		return "";
	}
	
}
