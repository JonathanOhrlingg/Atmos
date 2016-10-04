package com.jondevelopment.atmos;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.jondevelopment.atmos.states.MainMenu;
import com.jondevelopment.atmos.states.SplashScreen;

public class Game extends BasicGame {
	
	public static float scale = 1f;
	
	private List<GameState> gameStates = new ArrayList<GameState>();
	
	private GameState activeGameState = null;
	
	private int lastWidth, lastHeight;
	
	public Game() {
		super("Atmos");
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		Debug.log("Game done loading.");
		// Load add states
		addGameState(new SplashScreen());
		addGameState(new MainMenu());
		
		// Set the default state
		changeState(SplashScreen.ID);
		
		lastWidth = gc.getWidth();
		lastHeight = gc.getHeight();
	}
	
	@Override
	public void update(GameContainer gc, int milliDelta) throws SlickException {
		// Convert the millisecond delta to second delta
		float delta = (float)milliDelta/1000.0f;
		
		if(activeGameState != null)
			activeGameState.update(delta, gc);
		
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		float dx = (float)Display.getWidth()/1600f, dy = (float)Display.getHeight()/900f;
		Game.scale = (dx + dy)/2f;
		if(activeGameState != null)
			activeGameState.render(g, gc);
	}
	
	public void changeState(int id) {
		for(GameState compare : gameStates)
			if(compare.getID() == id) {
				activeGameState = compare;
				activeGameState.loadOnce();
				activeGameState.init();
			}
	}
	
	public void addGameState(GameState state) {
		for(GameState compare : gameStates)
			if(compare.getID() == state.getID()) {
				Debug.logError("GameState ID already in use.");
				return;
			}
		gameStates.add(state);
	}
	
}