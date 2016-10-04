package com.jondevelopment.atmos.scene;

public class Scene {
	
	private Tile[][] sceneTiles;
	
	public Scene(int width, int height) {
		sceneTiles = new Tile[width][height];
	}
	
	
	
	public Tile[][] getSceneTiles() {
		return sceneTiles;
	}
	
}
