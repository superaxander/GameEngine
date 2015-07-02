package net.alexanders.engine.util;

import net.alexanders.engine.render.*;
import org.lwjgl.*;

import java.nio.*;
import java.util.*;

public class Util
{
    public static IntBuffer createFlippedBuffer(int... values)
    {
        IntBuffer buffer = BufferUtils.createIntBuffer(values.length);
        buffer.put(values);
        buffer.flip();
        return buffer;
    }
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

    public static String[] removeEmptyStrings(String[] data) //from bennybox
    {
        ArrayList<String> result = new ArrayList<String>();

        for(String aData : data)
            if(!aData.equals(""))
                result.add(aData);

        String[] res = new String[result.size()];
        result.toArray(res);

        return res;
    }
    private static Random rand = new Random();
    public static float randomInRange(float min, float max) {
        return (float)(Math.random() < 0.5 ? ((1-Math.random()) * (max-min) + min) : (Math.random() * (max-min) + min));
    }
}
