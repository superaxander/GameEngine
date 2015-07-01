package net.alexanders.engine.base;

import org.lwjgl.opengl.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

public class RenderUtils
{
    public static void clearScreen(){
        //TODO: stencil buffer
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    }

    public static void initGraphics(){
        glClearColor(0f, 0f, 0f, 0f);
        glFrontFace(GL_CW);
        glCullFace(GL_BACK);
        glEnable(GL_CULL_FACE);
        glEnable(GL_DEPTH_TEST);
        //TODO: Depth Clamp

        GL11.glEnable(GL_FRAMEBUFFER_SRGB);
    }
}
