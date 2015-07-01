package net.alexanders.engine.base;

import org.lwjgl.input.*;

public class Game
{
    public Game()
    {
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
    }
}
