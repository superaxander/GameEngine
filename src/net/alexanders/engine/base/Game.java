package net.alexanders.engine.base;

import org.lwjgl.input.*;
import org.lwjgl.util.vector.*;

public class Game
{
    private Mesh mesh;

    public Game()
    {
        mesh = new Mesh();

        Vertex[] data = new Vertex[]{new Vertex(new Vector3f(-1, -1, 0)),
                                     new Vertex(new Vector3f(-1, 1, 0)),
                                     new Vertex(new Vector3f(0, 1, 0))};

        mesh.addVertices(data);
    }

    public void input()
    {
        if(Input.getKeyDown(Keyboard.KEY_Q))
            System.out.println("Pressed Q");
        if(Input.getKeyUp(Keyboard.KEY_Q))
            System.out.println("Released Q");
        if(Input.getMouseDown(1))
            System.out.println("Pressed MOUSE_1 "+Input.getMousePosition().toString());
        if(Input.getMouseUp(1))
            System.out.println("Released MOUSE_1"+Input.getMousePosition().toString());
    }

    public void update()
    {
    }

    public void render()
    {
        mesh.draw();
    }
}
