package net.alexanders.engine.base;

import java.io.*;

public class ResourceLoader
{
    public static String loadShader(String filename)
    {
        try{
            StringBuilder sb = new StringBuilder();
            BufferedReader fileReader = new BufferedReader(new FileReader("./data/shaders/"+filename));
            fileReader.lines().forEach(line -> sb.append(line).append('\n'));
            String source = sb.toString();
            if(source.equals(""))
            {
                System.err.println("Shader file empty");
                new IOException().printStackTrace();
                System.exit(1);
            }
            return sb.toString();
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        System.err.println("Shader file couldn't be loaded");
        new IOException().printStackTrace();
        System.exit(1);
        return null;
    }
}
