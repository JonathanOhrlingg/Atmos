package com.jondevelopment.atmos.states;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import com.jondevelopment.atmos.GameState;
import com.jondevelopment.atmos.Loader;
import com.jondevelopment.atmos.rendering.shaders.Shader;

public class ShaderTest extends GameState {
	
	public static final int ID = -1;
	
	private Shader shader;
	
	private Image image;
	
	@Override
	public void load() {
		image = Loader.getImage("logo_white");
	}
	
	@Override
	public void init() {
		shader = new Shader("vertex.shader","fragment.shader") {
			@Override
			public void getUniformLocations() {
			}
		};
	}
	
	@Override
	public void update(float delta, GameContainer gc) {
		
	}
	
	@Override
	public void render(Graphics g, GameContainer gc) {
		
		image.drawFlash(0, 0);
		
		shader.bind();
		GL11.glBegin(GL11.GL_TRIANGLES);
		{
			GL11.glVertex2f(-0.5f, -0.5f);
			GL11.glVertex2f(0.5f, -0.5f);
			GL11.glVertex2f(0f, 0.5f);
		}
		GL11.glEnd();
		shader.unbind();
	}
	
	@Override
	public int getID() {
		return ID;
	}
	
}