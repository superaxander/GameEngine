package net.alexanders.engine.base;

import net.alexanders.engine.interaction.*;
import net.alexanders.engine.render.*;
import org.lwjgl.input.*;
import org.lwjgl.util.vector.*;

public class Game
{
    private Mesh mesh;
    private Shader shader;
    private Transform transform;


    public Game()
    {
        mesh = new Mesh();
        shader = new Shader();
        transform = new Transform();

        Vertex[] data = new Vertex[] {new Vertex(new Vector3f(-1,-1,0)),
                new Vertex(new Vector3f(0,1,0)),
                new Vertex(new Vector3f(1,-1,0))};

        mesh.addVertices(data);
        shader.addVertexShader(ResourceLoader.loadShader("BasicVertexShader.vs"));
        shader.addFragmentShader(ResourceLoader.loadShader("BasicFragmentShader.fs"));
        shader.compile();
        shader.addUniform("transform");
    }

    public void input()
    {
        /*if(Input.getKeyDown(Keyboard.KEY_D))
            transform.setTranslation(-0.5f, 0, 0);
        if(Input.getKeyUp(Keyboard.KEY_D))
            transform.setTranslation(0, 0, 0);
        if(Input.getKeyDown(Keyboard.KEY_A))
            transform.setTranslation(0.5f, 0, 0);
        if(Input.getKeyUp(Keyboard.KEY_A))
            transform.setTranslation(0, 0, 0);
        if(Input.getKeyDown(Keyboard.KEY_S))
            transform.setTranslation(0, 0.5f, 0);
        if(Input.getKeyUp(Keyboard.KEY_S))
            transform.setTranslation(0, 0, 0);
        if(Input.getKeyDown(Keyboard.KEY_W))
            transform.setTranslation(0, -0.5f, 0);
        if(Input.getKeyUp(Keyboard.KEY_W))
            transform.setTranslation(0, 0, 0);*/
        if(Input.getMouseDown(1))
            System.out.println("Pressed MOUSE_1 "+Input.getMousePosition().toString());
        if(Input.getMouseUp(1))
            System.out.println("Released MOUSE_1"+Input.getMousePosition().toString());
    }

    float temp = 0.0f;

    public void update()
    {
       temp += Time.getDelta();
       //transform.setTranslation((float)Math.sin(temp),0,0);//+transform.getTranslation().getX(), transform.getTranslation().getY(), transform.getTranslation().getZ());
       transform.setRotation(0, 0, (float)Math.sin(temp)*180f);
    }

    public void render()
    {
        shader.bind();
        mesh.draw();
        shader.setUniform("transform", transform.getTransformation());
    }
}
