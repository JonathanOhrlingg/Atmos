package com.jondevelopment.atmos.rendering;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import com.jondevelopment.atmos.Debug;
import com.jondevelopment.atmos.Loader;

public class Fonts {
	
	public static final int THIN = 0, REGULAR = 1, BOLD = 2, CONDENSED = 3;
	
	public static final float FONT_QUALITY = 10f;
	
	private static class FontHolder {
		public int type;
		public boolean italic;
		public int size;
		public UnicodeFont font;
		
		public FontHolder(int type, boolean italic, int size, UnicodeFont font) {
			this.type = type;
			this.italic = italic;
			this.size = size;
			this.font = font;
		}
	}
	
	private static Font thinFont, regularFont, boldFont, condensedFont;
	
	private static List<FontHolder> fonts = new ArrayList<FontHolder>();
	
	private static int lastType, lastSize;
	private static boolean lastItalic;
	private static UnicodeFont lastFont;
	
	public static void init() {
		try {
			thinFont = Font.createFont(Font.TRUETYPE_FONT, Loader.getFileStream("fonts/Roboto-Thin.ttf"));
			thinFont.deriveFont(FONT_QUALITY);
			regularFont = Font.createFont(Font.TRUETYPE_FONT, Loader.getFileStream("fonts/Roboto-Regular.ttf"));
			regularFont.deriveFont(FONT_QUALITY);
			boldFont = Font.createFont(Font.TRUETYPE_FONT, Loader.getFileStream("fonts/Roboto-Black.ttf"));
			boldFont.deriveFont(FONT_QUALITY);
			condensedFont = Font.createFont(Font.TRUETYPE_FONT, Loader.getFileStream("fonts/Roboto-Condensed.ttf"));
			condensedFont.deriveFont(FONT_QUALITY);
		}
		catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void drawString(String message, int x, int y, int type, boolean italic, int size) {
		drawString(message, x, y, type, italic, size, Color.white);
	}
	
	public static void drawString(String message, int x, int y, int type, boolean italic, int size, Color color) {
		getFont(type, italic, size).drawString(x, y, message, color);
	}
	
	private static UnicodeFont getFont(int type, boolean italic, int size) {
		if(lastType == type && lastItalic == italic && lastSize == size)
			return lastFont;
		lastType = type;
		lastItalic = italic;
		lastSize = size;
		for(FontHolder font : fonts)
			if(font.type == type && font.size == size && font.italic == italic) {
				lastFont = font.font;
				return font.font;
			}
		UnicodeFont font = loadFont(type, italic, size);
		lastFont = font;
		return font;
	}
	
	@SuppressWarnings("unchecked")
	private static UnicodeFont loadFont(int type, boolean italic, int size) {
		Font baseFont = null;
		if(type == THIN)
			baseFont = thinFont;
		if(type == REGULAR)
			baseFont = regularFont;
		if(type == BOLD)
			baseFont = boldFont;
		if(type == CONDENSED)
			baseFont = condensedFont;
		UnicodeFont font = new UnicodeFont(baseFont, size, false, italic);
		font.addAsciiGlyphs();
		ColorEffect e = new ColorEffect();
		e.setColor(java.awt.Color.white);
		font.getEffects().add(e);
		try {
			font.loadGlyphs();
		}
		catch (SlickException e1) {
			e1.printStackTrace();
		}
		fonts.add(new FontHolder(type, italic, size, font));
		return font;
	}
}