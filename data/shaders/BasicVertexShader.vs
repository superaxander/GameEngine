#version 150 core

in vec3 position;

out vec4 vertexColor;

uniform mat4 transform;

void main()
{
    gl_Position = transform * vec4(position, 1);
    vertexColor = vec4(clamp(position, 0, 1), 1);
}