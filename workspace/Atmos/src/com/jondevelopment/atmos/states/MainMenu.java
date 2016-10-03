package com.jondevelopment.atmos.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.jondevelopment.atmos.GameState;

public class MainMenu extends GameState {
	
	public static final int ID = 1;
	
	@Override
	public void load() {
		
	}
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void update(float delta, GameContainer gc) {
		
	}
	
	@Override
	public void render(Graphics g, GameContainer gc) {
		g.drawString("Main Menu", 100, 100);
	}
	
	@Override
	public int getID() {
		return ID;
	}
	
}