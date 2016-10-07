package com.jondevelopment.atmos.ui;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;

public class UOverlay {
	
	public List<UObject> objects;
	
	public UOverlay() {
		objects = new ArrayList<UObject>();
	}
	
	public void render(Graphics g) {
		for(UObject object : objects)
			object.render(g);
	}
	
	public void update(float delta) {
		for(UObject object : objects)
			object.update(delta);
	}
	
	public void onClick(int x, int y, int mouse) {
		for(UObject object : objects)
			object.onClick(x, y, mouse);
	}
	
	public void addObject(UObject object) {
		objects.add(object);
	}
	
	public void removeObject(UObject object) {
		objects.remove(object);
	}
	
}
