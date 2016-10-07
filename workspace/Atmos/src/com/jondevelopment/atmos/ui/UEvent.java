package com.jondevelopment.atmos.ui;

public abstract class UEvent {
	
	public static final int MOUSE_LEFT = 0, MOUSE_RIGHT = 1, MOUSE_MIDDLE = 2;
	
	public abstract void onEvent(UObject parent, String[] info);
	
}
