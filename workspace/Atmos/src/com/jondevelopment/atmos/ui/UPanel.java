package com.jondevelopment.atmos.ui;

import org.newdawn.slick.Image;

public class UPanel {
	
	public Image image;
	public float x, y, width, height;
	
	public UPanel(Image image, float x, float y) {
		this(image, x, y, image.getWidth(), image.getHeight());
	}
	
	public UPanel(Image image, float x, float y, float width, float height) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void onClick(int x, int y) {
		
	}
	
	public void render() {
		
	}
	
	
	
}
