package com.jondevelopment.atmos;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.jondevelopment.atmos.states.MainMenu;
import com.jondevelopment.atmos.states.SplashScreen;

public class Game extends BasicGame {
	
	private List<GameState> gameStates = new ArrayList<GameState>();
	
	private GameState activeGameState = null;
	private boolean hasChangedState = false;
	
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