package com.jondevelopment.atmos.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import com.jondevelopment.atmos.Game;
import com.jondevelopment.atmos.GameState;
import com.jondevelopment.atmos.Launcher;
import com.jondevelopment.atmos.Loader;
import com.jondevelopment.atmos.MusicHandler;
import com.jondevelopment.atmos.Settings;

public class SplashScreen extends GameState {
	
	public static final int ID = 0;
	
	private Image logo;
	private Color fadeColor;
	private float fadeTime;
	
	@Override
	public void load() {
		logo = Loader.getImage("logo_white");
	}
	
	@Override
	public void init() {
		fadeTime = 0;
		fadeColor = new Color(1f,1f,1f,0f);
		MusicHandler.start(MusicHandler.MAIN_MENU);
	}
	
	@Override
	public void update(float delta, GameContainer gc) {
		fadeTime += delta;
		if(fadeTime <= 2) {
			fadeColor.a = fadeTime / 2f;
		}
		else if(fadeTime >= 3 && fadeTime <= 5) {
			fadeColor.a = 1f - (fadeTime-3f) / 2f;
		}
		else if (fadeTime > 5){
			Launcher.getGame().changeState(MainMenu.ID);
		}
	}
	
	@Override
	public void render(Graphics g, GameContainer gc) {
		logo.draw((Settings.Screen.width-logo.getWidth()*Game.scale)/2, (Settings.Screen.height-logo.getHeight()*Game.scale)/2, Game.scale, fadeColor);
	}
	
	@Override
	public int getID() {
		return ID;
	}
	
}
