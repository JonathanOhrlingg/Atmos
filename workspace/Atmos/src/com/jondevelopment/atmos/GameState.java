package com.jondevelopment.atmos;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class GameState {
	
	public boolean alwaysLoad = false;
	
	public boolean hasLoaded = false;
	public void loadOnce() {
		if(!hasLoaded || alwaysLoad)
			load();
		hasLoaded = true;
	}
	
	// The load method is for loading images and other resources and will only be called once per game (by default)
	public abstract void load();
	
	public abstract void init();
	
	public abstract void update(float delta, GameContainer gc);
	
	public abstract void render(Graphics g, GameContainer gc);
	
	public abstract int getID();
	
}
