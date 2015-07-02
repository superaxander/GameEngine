#version 150 core

in vec4 vertexColor;
out vec4 fragColor;
//uniform vec3 colorIn;

void main()
{
    fragColor = vertexColor;
    //clamp(vertexColor * 0.5 * vec4(colorIn, 1.0), 0, 1);
}