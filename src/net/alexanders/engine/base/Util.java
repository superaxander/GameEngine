package net.alexanders.engine.base;

import org.lwjgl.*;

import java.nio.*;

public class Util
{
    public static FloatBuffer createFlippedBuffer(Vertex[] vertices)
    {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length * Vertex.SIZE);
        for(Vertex vertex : vertices)
        {
            buffer.put(vertex.getPosition().getX());
            buffer.put(vertex.getPosition().getY());
            buffer.put(vertex.getPosition().getZ());
        }
        buffer.flip();
        return buffer;
    }
}
