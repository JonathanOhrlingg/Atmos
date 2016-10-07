package com.jondevelopment.atmos.editor;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.jondevelopment.atmos.Loader;
import com.jondevelopment.atmos.rendering.Fonts;
import com.jondevelopment.atmos.ui.UButton;
import com.jondevelopment.atmos.ui.UEvent;
import com.jondevelopment.atmos.ui.UObject;
import com.jondevelopment.atmos.ui.UOverlay;
import com.jondevelopment.atmos.ui.UPanel;
import com.jondevelopment.atmos.ui.UText;

public class Editor extends BasicGame {
	
	public UOverlay overlay;
	
	public Editor() {
		super("Atmos Tile Editor");
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		overlay = new UOverlay();
		UPanel panel = new UPanel(Loader.getImage("overlay/editor/info_panel"), 0, 0, 256, 40);
		UButton button = new UButton(Loader.getImage("overlay/editor/medium_button"), 3, 3f, 128, 32, new UEvent() {
			@Override
			public void onEvent(UObject parent, String[] info) {
				System.out.println("Click");
			}
		});
		UText text = new UText("Button", 16, Fonts.REGULAR, false, UText.CENTER, 0, 0, 0, 128, 32);
		text.parent = button;
		button.parent = panel;
		overlay.addObject(panel);
		overlay.addObject(button);
		overlay.addObject(text);
	}
	
	@Override
	public void update(GameContainer gc, int milliDelta) throws SlickException {
		float delta = (float)milliDelta/1000.0f;
		overlay.update(delta);
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		overlay.render(g);
	}
	
	@Override
	public void mousePressed(int button, int x, int y) {
		int mouse = -1;
		if(button == Input.MOUSE_LEFT_BUTTON)
			mouse = UEvent.MOUSE_LEFT;
		if(button == Input.MOUSE_RIGHT_BUTTON)
			mouse = UEvent.MOUSE_RIGHT;
		if(button == Input.MOUSE_MIDDLE_BUTTON)
			mouse = UEvent.MOUSE_MIDDLE;
		overlay.onClick(x, y, mouse);
	}
	
}
