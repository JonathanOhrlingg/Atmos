package com.jondevelopment.atmos.ui;

import org.newdawn.slick.Image;

public class UButton extends UPanel {
	
	public UEvent event;
	
	public UButton(Image image, float x, float y, float width, float height, UEvent event) {
		super(image, x, y, width, height);
		this.event = event;
	}
	
	@Override
	public void onClick(int x, int y, int mouse) {
		if(inBounds(this,width,height,x,y) && event != null)
			event.onEvent(parent, new String[]{"" + x, "" + y, "" + mouse});
	}
	
	
	
}
