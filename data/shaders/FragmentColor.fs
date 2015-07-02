#version 150 core

out vec4 fragColor;
uniform vec3 colorIn;

void main()
{
    fragColor = vec4(colorIn, 1.0);
}