package net.alexanders.engine.base;

import net.alexanders.engine.interaction.*;
import net.alexanders.engine.render.*;
import net.alexanders.engine.util.*;

public class MainComponent
{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "3D Engine";
    public static final double MAX_UPDATES_PER_SECOND = 5000.0;

    private boolean isRunning;
    private Game game;

    public MainComponent()
    {
        System.out.println(RenderUtil.getOpenGLVersion());
        RenderUtil.initGraphics();
        this.isRunning = false;
        this.game = new Game();
    }

    public void start()
    {
        if(isRunning)
            return;

        this.isRunning = true;
        process();
    }

    public void stop()
    {
        if(!isRunning)
            return;

        this.isRunning = false;
        cleanUp();
    }

    private void process()
    {
        int frames = 0;
        int frameCounter = 0;

        final double updateTime = 1 / MAX_UPDATES_PER_SECOND;
        long lastTime = Time.getTime();
        double unprocessedTime = 0;

        while(isRunning)
        {
            boolean render = false;

            long startTime = Time.getTime();
            long passedTime = startTime - lastTime;
            lastTime = startTime;

            unprocessedTime += passedTime / (double)Time.SECOND;
            frameCounter += passedTime;

            while(unprocessedTime > updateTime)
            {
                render = true;
                unprocessedTime -= updateTime;
                if(Window.isCloseRequested())
                {
                    stop();
                    return;
                }

                Time.setDelta(updateTime);

                Input.update();

                game.input();
                game.update();

                if(frameCounter >= Time.SECOND)
                {
                    System.out.println(frames);
                    frames = 0;
                    frameCounter = 0;
                }
            }
            if(render)
            {
                render();
                frames++;
            }else
            {
                try{
                    Thread.sleep(1);
                }catch(InterruptedException e){
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }

    private void render()
    {
        RenderUtil.clearScreen();
        game.render();
        Window.render();
    }

    private void cleanUp()
    {
        Window.destroy();
    }

    public static void main(String[] args){
        Window.createWindow(WIDTH, HEIGHT, TITLE);

        MainComponent game = new MainComponent();

        game.start();
    }
}
