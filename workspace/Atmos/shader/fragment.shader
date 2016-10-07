#version 330 core

out vec4 fragColor;

in vec4 passPosition;
in vec4 passColor;
in vec3 passNormal;

void main() {
	fragColor = vec4(passPosition.xyz, 1.0);
}