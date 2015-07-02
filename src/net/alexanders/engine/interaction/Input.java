package net.alexanders.engine.interaction;

import org.lwjgl.input.*;
import org.lwjgl.util.vector.*;

import java.util.*;

public class Input
{
    public static final int NUM_KEYCODES = 256;
    public static final int NUM_MOUSE_BUTTONS = 20;

    private static ArrayList<Integer> currentKeys = new ArrayList<>();
    private static ArrayList<Integer> downKeys = new ArrayList<>();
    private static ArrayList<Integer> upKeys = new ArrayList<>();

    private static ArrayList<Integer> currentMouse = new ArrayList<>();
    private static ArrayList<Integer> downMouse = new ArrayList<>();
    private static ArrayList<Integer> upMouse = new ArrayList<>();

    public static void update()
    {
        //Process mouse
        upMouse.clear();

        downMouse.clear();

        for(int i=0; i < NUM_MOUSE_BUTTONS; i++)
            if(!getMouse(i) && currentMouse.contains(i))
                upMouse.add(i);

        for(int i=0; i < NUM_MOUSE_BUTTONS; i++)
            if(getMouse(i) && !currentMouse.contains(i))
                downMouse.add(i);

        currentMouse.clear();

        for(int i=0; i < NUM_MOUSE_BUTTONS; i++)
            if(getMouse(i))
                currentMouse.add(i);

        //Process keyboard
        upKeys.clear();

        downKeys.clear();

        for(int i=0; i < NUM_KEYCODES; i++)
            if(!getKey(i) && currentKeys.contains(i))
                upKeys.add(i);

        for(int i=0; i < NUM_KEYCODES; i++)
            if(getKey(i) && !currentKeys.contains(i))
                downKeys.add(i);

        currentKeys.clear();

        for(int i=0; i < NUM_KEYCODES; i++)
            if(getKey(i))
                currentKeys.add(i);

    }
    public static boolean getKey(int keyCode)
    {
        return Keyboard.isKeyDown(keyCode);
    }

    public static boolean getKeyDown(int keyCode)
    {
        return downKeys.contains(keyCode);

    }

    public static boolean getKeyUp(int keyCode)
    {
        return upKeys.contains(keyCode);

    }

    public static boolean getMouse(int mouseButton)
    {
        return Mouse.isButtonDown(mouseButton);
    }

    public static boolean getMouseDown(int mouseButton)
    {
        return downMouse.contains(mouseButton);
    }

    public static boolean getMouseUp(int mouseButton)
    {
        return upMouse.contains(mouseButton);
    }

    public static Vector2f getMousePosition()
    {
        return new Vector2f(Mouse.getX(), Mouse.getY());
    }
}
