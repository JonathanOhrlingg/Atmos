#version 330 core

layout(location = 0) in vec3 position;
layout(location = 1) in vec2 texture;
layout(location = 2) in vec3 normal;
layout(location = 3) in vec4 color;

uniform mat4 projMatrix;
uniform mat4 modelMatrix;

out vec4 passPosition;
out vec4 passColor;
out vec3 passNormal;

void main(void) {
	gl_Position = vec4(position, 1.0);
	passPosition = gl_Position;
	passColor = color;
	passNormal = normal;
}