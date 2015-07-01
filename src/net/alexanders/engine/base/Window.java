package net.alexanders.engine.base;

import org.lwjgl.*;
import org.lwjgl.opengl.*;

public class Window
{
    public static void createWindow(int width, int height, String title){
        Display.setTitle(title);
        try{
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
        }catch(LWJGLException e){
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }
    }

    public static void render()
    {
        Display.update();
    }

    public static boolean isCloseRequested()
    {
        return Display.isCloseRequested();
    }

    public static int getWidth()
    {
        return Display.getDisplayMode().getWidth();
    }

    public static int getHeight()
    {
        return Display.getDisplayMode().getHeight();
    }

    public static String getTitle()
    {
        return Display.getTitle();
    }

    public static void setWidth(int width)
    {
        try{
            Display.setDisplayMode(new DisplayMode(width, getHeight()));
        }catch(LWJGLException e){
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }
    }

    public static void setHeight(int height)
    {
        try{
            Display.setDisplayMode(new DisplayMode(getWidth(), height));
        }catch(LWJGLException e){
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }
    }

    public static void setWidthAndHeight(int width, int height)
    {
        try{
            Display.setDisplayMode(new DisplayMode(width, height));
        }catch(LWJGLException e){
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }
    }

    public static void setTitle(String title)
    {
        Display.setTitle(title);
    }
}
