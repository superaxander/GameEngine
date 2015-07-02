package net.alexanders.engine.base;

import net.alexanders.engine.interaction.*;
import net.alexanders.engine.render.*;
import net.alexanders.engine.util.*;
import org.lwjgl.input.*;
import org.lwjgl.util.vector.*;

import java.util.*;

public class Game
{
    private ArrayList<Mesh> meshes = new ArrayList<>();
    private ArrayList<Shader> shaders = new ArrayList<>();
    private ArrayList<Transform> transforms = new ArrayList<>();
    private ArrayList<Vector3f> colors = new ArrayList<>();


    public Game()
    {
        meshes = ResourceLoader.loadMeshes("cube.obj");
        System.out.println(meshes.size());
        for(Mesh mesh : meshes)
        {
            Shader shader = new Shader();
            shader.addFragmentShader(ResourceLoader.loadShader("FragmentColor.fs"));
            shader.addVertexShader(ResourceLoader.loadShader("VertexColor.vs"));
            shader.compile();
            shader.addUniform("colorIn");
            shaders.add(shader);
            Transform transform = new Transform();
            transform.setScale(0.2f, 0.2f, 0.2f);
            transforms.add(transform);
            shader.addUniform("transform");
            colors.add(new Vector3f(Util.randomInRange(0.2f, 0.8f), Util.randomInRange(0.2f, 0.8f), Util.randomInRange(0.2f, 0.8f)));
        }
        //mesh = ResourceLoader.loadMeshFile("cube.obj");
        //shader = new Shader();
        //transform = new Transform();
        //transform.setScale(0.2f, 0.2f, 0.2f);
        //shader.addVertexShader(ResourceLoader.loadShader("BasicVertexShader.vs"));
        //shader.addFragmentShader(ResourceLoader.loadShader("BasicFragmentShader.fs"));
        //shader.compile();
        //shader.addUniform("transform");
        //shader.addUniform("colorIn");
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
    float temp2 = 0.0f;
    float counter = 0.0f;

    public void update()
    {
       counter++;
       if(counter >= 5){
           temp += Time.getDelta();
           temp2 += Time.getDelta()/2;
           counter = 0;
           //System.out.println(Util.randomInRange(0.5f, 1));
       }
       for(Transform transform : transforms){
           //transform.setTranslation((float)Math.sin(temp),0,0);//+transform.getTranslation().getX(), transform.getTranslation().getY(), transform.getTranslation().getZ());
           transform.setRotation((float)Math.abs(Math.cos(temp2)) * 150f, (float)Math.abs(Math.sin(temp)) * 360f, 0);
           //float tmp = (float)Math.sin(temp);
           //transform.setScale(tmp > 0 ? tmp : -tmp, tmp > 0 ? tmp : -tmp, 0);
       }
    }

    public void render()
    {
        for(int i = 0; i < shaders.size(); i++){
            Shader shader = shaders.get(i);
            shader.bind();
            shader.setUniform("colorIn", colors.get(i));
            shader.setUniform("transform", transforms.get(i).getTransformation());
            meshes.get(i).draw();
        }
        //shader.setUniform("colorIn", new Vector3f((float)Math.sin(temp), (float)Math.cos(temp), (float)Math.abs(Math.sin(temp))));
    }
}
