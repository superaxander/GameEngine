package net.alexanders.engine.base;

import net.alexanders.engine.render.*;
import net.alexanders.engine.util.*;
import org.lwjgl.util.vector.*;

import java.io.*;
import java.util.*;

public class ResourceLoader{
    public static String loadShader(String filename){
        try{
            StringBuilder sb = new StringBuilder();
            BufferedReader fileReader = new BufferedReader(new FileReader("./data/shaders/" + filename));
            fileReader.lines().forEach(line -> sb.append(line).append('\n'));
            String source = sb.toString();
            if(source.equals("")){
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

    public static Mesh loadMeshFile(String filename){
        try{
            ArrayList<Vertex> vertices = new ArrayList<>();
            ArrayList<Integer> indices = new ArrayList<>();
            BufferedReader fileReader = new BufferedReader(new FileReader("./data/models/" + filename));

            fileReader.lines().forEach(line -> {

                switch(line.charAt(0)){
                    case ' ':
                    case '\n':
                    case '#':
                        break;
                    case 'v':
                        String[] splitv = Util.removeEmptyStrings(line.split(" "));
                        vertices.add(new Vertex(new Vector3f(Float.parseFloat(splitv[1]), Float.parseFloat(splitv[2]), Float.parseFloat(splitv[3]))));
                        break;
                    case 'f':
                        String[] splitf = Util.removeEmptyStrings(line.split(" "));

                        indices.add(Integer.parseInt(splitf[1])-1);
                        indices.add(Integer.parseInt(splitf[2])-1);
                        indices.add(Integer.parseInt(splitf[3])-1);
                        break;

                }
            });

            if(vertices.size() == 0 || indices.size() == 0){
                System.err.println("Invalid Obj file");
                new IOException().printStackTrace();
                System.exit(1);
            }

            Mesh mesh = new Mesh();
            int[] indicesInt = new int[indices.size()];
            for(int i = 0; i < indices.size(); i++){
                indicesInt[i] = indices.get(i);
            }
//            vertices.forEach(System.out::println);
//            indices.forEach(System.out::println);
            mesh.addVertices(vertices.toArray(new Vertex[vertices.size()]), indicesInt);
            return mesh;
        }catch(IOException e){
            ErrorHandler.errorAndExit(e, "Error reading Obj file", true, 1);
        }
        ErrorHandler.errorAndExit("Error reading Obj file", true);
        return null;
    }

    public static ArrayList<Mesh> loadMeshes(String filename){
        try{
            ArrayList<Vertex> vertices = new ArrayList<>();
            ArrayList<Integer> indices = new ArrayList<>();
            ArrayList<Mesh> meshes = new ArrayList<>();
            BufferedReader fileReader = new BufferedReader(new FileReader("./data/models/" + filename));

            fileReader.lines().forEach(line -> {

                switch(line.charAt(0)){
                    case ' ':
                    case '\n':
                    case '#':
                        break;
                    case 'v':
                        String[] splitv = Util.removeEmptyStrings(line.split(" "));
                        vertices.add(new Vertex(new Vector3f(Float.parseFloat(splitv[1]), Float.parseFloat(splitv[2]), Float.parseFloat(splitv[3]))));
                        break;
                    case 'f':
                        String[] splitf = Util.removeEmptyStrings(line.split(" "));

                        indices.add(Integer.parseInt(splitf[1])-1);
                        indices.add(Integer.parseInt(splitf[2])-1);
                        indices.add(Integer.parseInt(splitf[3])-1);
                        break;

                }
            });

            if(vertices.size() == 0 || indices.size() == 0){
                System.err.println("Invalid Obj file");
                new IOException().printStackTrace();
                System.exit(1);
            }

            //Mesh mesh = new Mesh();
            int[] indicesInt = new int[indices.size()];
            for(int i = 0; i < indices.size(); i++){
                indicesInt[i] = indices.get(i);
            }
//            vertices.forEach(System.out::println);
//            indices.forEach(System.out::println);
            //mesh.addVertices(vertices.toArray(new Vertex[vertices.size()]), indicesInt);
            for(int i = 0; i < indices.size(); i+=3){
                Mesh newMesh = new Mesh();
                newMesh.addVertices(vertices.toArray(new Vertex[vertices.size()]), new int[]{indices.get(i), indices.get(i+1), indices.get(i+2)});
                meshes.add(newMesh);
            }
            return meshes;
        }catch(IOException e){
            ErrorHandler.errorAndExit(e, "Error reading Obj file", true, 1);
        }
        ErrorHandler.errorAndExit("Error reading Obj file", true);
        return null;
    }
}
