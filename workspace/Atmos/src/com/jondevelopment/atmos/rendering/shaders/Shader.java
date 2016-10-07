package com.jondevelopment.atmos.rendering.shaders;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.geom.Vector2f;

import com.jondevelopment.atmos.Loader;

public abstract class Shader {
	
int programID, vertexID, fragmentID;
	
	public Shader(String vertex, String fragment) {
		programID = GL20.glCreateProgram();
		attachVertexShader(vertex);
		attachFragmentShader(fragment);
		link();
		getUniformLocations();
	}
	
	public abstract void getUniformLocations();
	
	public int getUnifomrLocation(String name) {
		return GL20.glGetUniformLocation(programID, name);
	}
	
	// Uniform loading methods
	public void loadVector(int location, Vector3f vector) {
		GL20.glUniform3f(location, vector.x, vector.y, vector.z);
	}
	public void loadVector(int location, Vector2f vector) {
		GL20.glUniform2f(location, vector.x, vector.y);
	}
	public void loadMatrix(int location, Matrix4f matrix) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(16);
		matrix.store(buffer);
		buffer.flip();
		GL20.glUniformMatrix4(location, false, buffer);
	}
	public void loadInt(int location, int value) {
		GL20.glUniform1i(location, value);
	}
	public void loadFloat(int location, float value) {
		GL20.glUniform1f(location, value);
	}
	
	private void attachVertexShader(String vertex) {
		String vertexShaderSource = Loader.readShaderFile(vertex);
		
		vertexID = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
		GL20.glShaderSource(vertexID, vertexShaderSource);
		
		GL20.glCompileShader(vertexID);
		
		if(GL20.glGetShaderi(vertexID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
			throw new RuntimeException("Error creating vertex shader\n" + GL20.glGetShaderInfoLog(vertexID, GL20.glGetShaderi(vertexID, GL20.GL_INFO_LOG_LENGTH)));
		}
		GL20.glAttachShader(programID, vertexID);
	}
	
	private void attachFragmentShader(String fragment) {
		String fragmentShaderSource = Loader.readShaderFile(fragment);
		
		fragmentID = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);
		GL20.glShaderSource(fragmentID, fragmentShaderSource);
		
		GL20.glCompileShader(fragmentID);
		
		if(GL20.glGetShaderi(fragmentID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
			throw new RuntimeException("Error creating vertex shader\n" + GL20.glGetShaderInfoLog(fragmentID, GL20.glGetShaderi(fragmentID, GL20.GL_INFO_LOG_LENGTH)));
		}
		GL20.glAttachShader(programID, fragmentID);
	}
	
	private void link() {
		GL20.glLinkProgram(programID);
		
		if(GL20.glGetProgrami(programID, GL20.GL_LINK_STATUS) == GL11.GL_FALSE) {
			throw new RuntimeException("Unable to link shader program");
		}
	}
	
	// Binding and cleaning methods
	public void bind() {
		GL20.glUseProgram(programID);
	}
	
	public void unbind() {
		GL20.glUseProgram(0);
	}
	
	public void dispose() {
		unbind();
		
		GL20.glDetachShader(programID, vertexID);
		GL20.glDetachShader(programID, fragmentID);
		
		GL20.glDeleteShader(vertexID);
		GL20.glDeleteShader(fragmentID);
		
		GL20.glDeleteProgram(programID);
	}
	
}
