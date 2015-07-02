package net.alexanders.engine.util;

import net.alexanders.engine.render.*;
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

    public static FloatBuffer createFlippedBuffer(Matrix4f matrix)
    {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(16);     //4*4
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                buffer.put(matrix.get(i, j));
            }
        }
        buffer.flip();
        return buffer;
    }
}
