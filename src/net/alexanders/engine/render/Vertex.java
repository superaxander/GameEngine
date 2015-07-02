package net.alexanders.engine.render;

import org.lwjgl.util.vector.*;

public class Vertex
{
    public static final int SIZE = 3;

    private Vector3f position;

    public Vertex(Vector3f position){
        this.position = position;
    }

    public Vector3f getPosition(){
        return position;
    }

    public void setPosition(Vector3f position){
        this.position = position;
    }
}
