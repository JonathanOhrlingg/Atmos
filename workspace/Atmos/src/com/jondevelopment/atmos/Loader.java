package com.jondevelopment.atmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
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
	
	public static InputStream getFileStream(String path) {
		return Class.class.getResourceAsStream("/" + path);
	}
	
	public static String[] loadTextFile(String path) {
		try {
			return IOUtils.toString(getFileStream(path), Charset.defaultCharset()).split(System.lineSeparator());
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(Main.ERROR);
		}
		return null;
	}
	
	public static String readShaderFile(String path) {
		StringBuilder source = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(Class.class.getResourceAsStream("/" + path)));
			String line;
			while((line = reader.readLine()) != null) {
				source.append(line).append('\n');
			}
			reader.close();
		}
		catch (Exception e) {
			System.err.println("Error loadig file at: " + path);
			e.printStackTrace();
			System.exit(1);
		}
		return source.toString();
	}
	
	public static String[] loadAbsoluteTextFile(String path) {
		try {
			return FileUtils.readFileToString(new File(path), Charset.defaultCharset()).split(System.lineSeparator());
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(Main.ERROR);
		}
		return null;
	}
	
	public static void writeAbsoluteTextFile(String path, String content) {
		try {
			FileUtils.write(new File(path), content, Charset.defaultCharset());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
