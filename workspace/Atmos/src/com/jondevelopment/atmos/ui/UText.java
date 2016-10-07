package com.jondevelopment.atmos.ui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.UnicodeFont;

import com.jondevelopment.atmos.rendering.Fonts;

public class UText extends UObject {
	
	public static final int CENTER = 0, LEFT = 1, RIGHT = 2;
	public static final int STATIC = 0, DYNAMIC = 1;
	
	public String text;
	public int size, type;
	public boolean italic;
	public int flow, updateMode;
	public float width, height;
	
	public UText(String text, int size, int type, boolean italic, int updateMode, float x, float y, float width, float height) {
		this(text, size, type, italic, updateMode, CENTER, x, y, width, height);
	}
	
	public UText(String text, int size, int type, boolean italic, int updateMode, int flow, float x, float y, float width, float height) {
		super(x, y);
		this.text = text;
		this.size = size;
		this.type = type;
		this.italic = italic;
		this.updateMode = updateMode;
		this.flow = flow;
		this.height = height;
		this.width = width;
	}

	@Override
	public void render(Graphics g) {
		UnicodeFont font = Fonts.getFont(type, italic, size);
		float w = font.getWidth(text);
		float h = font.getHeight(text);
		
		float ch = (height - h) / 2 - 2;
		float cw = 0f;
		
		if(flow == CENTER) {
			cw = (width - w) / 2 - 2;
		}
		
		float[] sum = getPositionSum(this);
		Fonts.drawString(text, (int)(sum[0] + cw), (int)(sum[1] + ch), type, italic, size);
	}

	@Override
	public void update(float delta) {
		
	}
	
	
	
}
