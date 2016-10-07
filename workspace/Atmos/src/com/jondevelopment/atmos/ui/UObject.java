package com.jondevelopment.atmos.ui;

import org.newdawn.slick.Graphics;

public abstract class UObject {
	
	public float x, y;
	
	public UObject parent;
	
	public UObject(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void render(Graphics g);
	
	public abstract void update(float delta);
	
	public void onClick(int x, int y, int mouse){};
	
	// Help methods
	
	public float[] getPositionSum(UObject origin) {
		float sumX = origin.x, sumY = origin.y;
		UObject lastParent = origin;
		while(true) {
			if(lastParent != null)
				lastParent = lastParent.parent;
			if(lastParent == null)
				break;
			sumX += lastParent.x;
			sumY += lastParent.y;
		}
		return new float[] {sumX, sumY};
	}
	
	public boolean inBounds(UObject origin, float width, float height, int mx, int my) {
		float[] sum = getPositionSum(origin);
		float x = sum[0], y = sum[1];
		if(mx >= x &&  my >= y && mx <= x + width && my <= y + height)
			return true;
		return false;
	}
	
}
