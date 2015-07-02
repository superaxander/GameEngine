package net.alexanders.engine.render;

import net.alexanders.engine.util.*;
import net.alexanders.engine.util.Matrix4f;
import org.lwjgl.util.vector.*;

import java.util.*;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.*;

public class Shader
{
    private int program;
    private HashMap<String, Integer> uniforms;

    public Shader()
    {
        program = glCreateProgram();
        uniforms = new HashMap<>();
        if(program == 0)
        {
            System.err.println("Couldn't allocate space for shader in constructor");
            new Exception().printStackTrace();
            System.exit(1);
        }
    }

    public void compile()
    {
        glBindAttribLocation(program, 0, "position");
        glLinkProgram(program);
        if(glGetProgrami(program, GL_LINK_STATUS) == 0)
        {
            System.err.println("Failed to link shader");
            System.err.println(glGetProgramInfoLog(program, 1024));
            new Exception().printStackTrace();
            System.exit(1);
        }
        glValidateProgram(program);
        if(glGetProgrami(program, GL_VALIDATE_STATUS) == 0)
        {
            System.err.println("Failed to validate shader");
            System.err.println(glGetProgramInfoLog(program, 1024));
            new Exception().printStackTrace();
            System.exit(1);
        }
    }

    public void bind()
    {
        glUseProgram(program);
    }

    public void addUniform(String name)
    {
        int uniformLocation = glGetUniformLocation(program, name);
        if(uniformLocation == -1)
        {
            ErrorHandler.errorAndExit("Couldn't allocate uniform space", true);
        }
        uniforms.put(name, uniformLocation);
    }
    public void addVertexShader(String text)
    {
        addProgram(text, GL_VERTEX_SHADER);
    }

    public void addGeometryShader(String text)
    {
        addProgram(text, GL_GEOMETRY_SHADER);
    }

    public void addFragmentShader(String text)
    {
        addProgram(text, GL_FRAGMENT_SHADER);
    }

    private void addProgram(String text, int type)
    {
        int shader = glCreateShader(type);
        if(shader == 0)
        {
            System.err.println("Couldn't allocate space while adding shader program");
            new Exception().printStackTrace();
            System.exit(1);
        }
        glShaderSource(shader, text);
        glCompileShader(shader);

        if(glGetShaderi(shader, GL_COMPILE_STATUS) == 0)
        {
            System.err.println("Failed to compile shader");
            System.err.println(glGetShaderInfoLog(shader, 1024));
            new Exception().printStackTrace();
            System.exit(1);
        }
        glAttachShader(program, shader);
    }

    public void setUniform(String uniform, int value)
    {
        glUniform1i(uniforms.get(uniform), value);
    }
    public void setUniform(String uniform, float value)
    {
        glUniform1f(uniforms.get(uniform), value);
    }
    public void setUniform(String uniform, Vector3f value)
    {
        glUniform3f(uniforms.get(uniform), value.getX(), value.getY(), value.getZ());
    }
    public void setUniform(String uniform, Matrix4f value)
    {
        glUniformMatrix4(uniforms.get(uniform), true, Util.createFlippedBuffer(value));
    }

}
