package com.jondevelopment.atmos.ui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import com.jondevelopment.atmos.Game;

public class UPanel extends UObject {
	
	public Image image;
	public float width, height;
	
	public UPanel(Image image, float x, float y) {
		this(image, x, y, image.getWidth(), image.getHeight());
	}
	
	public UPanel(Image image, float x, float y, float width, float height) {
		super(x,y);
		this.image = image;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void render(Graphics g) {
		float[] sum = getPositionSum(this);
		image.draw(sum[0] * Game.scale, sum[1] * Game.scale, width * Game.scale, height * Game.scale);
	}
	
	@Override
	public void update(float delta) {
		
	}
	
}
