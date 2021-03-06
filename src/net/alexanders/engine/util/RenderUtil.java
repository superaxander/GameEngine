package net.alexanders.engine.util;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

public class RenderUtil
{
    public static void clearScreen(){
        //TODO: stencil buffer
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public static void initGraphics(){
        glClearColor(0f, 0f, 0f, 0f);
        glFrontFace(GL_CW);
        glCullFace(GL_BACK);
        glEnable(GL_CULL_FACE);
        glEnable(GL_DEPTH_TEST);
        //TODO: Depth Clamp

        glEnable(GL_FRAMEBUFFER_SRGB);
    }

    public static String getOpenGLVersion()
    {
        return glGetString(GL_VERSION);
    }
}
