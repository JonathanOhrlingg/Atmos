package com.jondevelopment.atmos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Loader {
	
	public static List<Image> loadedImages = new ArrayList<Image>();
	public static List<String> loadedImagesPaths = new ArrayList<String>();
	
	public static List<Integer> textures = new ArrayList<Integer>();
	
	public static Image getImage(String relativePath) {
		if(loadedImagesPaths.contains(relativePath))
			return loadedImages.get(loadedImagesPaths.indexOf(relativePath));
		return loadImage(relativePath);
	}
	
	private static Image loadImage(String path) {
		Image image = null;
		try {
			Texture texture = TextureLoader.getTexture("PNG", Class.class.getResourceAsStream("/" + path + ".png"));
			textures.add(texture.getTextureID());
			image = new Image(texture);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(Main.ERROR);
		}
		return image;
	}
	
}
