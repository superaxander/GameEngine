package net.alexanders.engine.base;

public class MainComponent
{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "3D Engine";

    public MainComponent()
    {

    }

    public void start()
    {
        process();
    }

    public void stop()
    {

    }

    public void process()
    {
        while(!Window.isCloseRequested())
        {
            render();
        }
        cleanUp();
    }

    public void render()
    {
        Window.render();
    }

    public void cleanUp()
    {

    }

    public static void main(String[] args){
        Window.createWindow(WIDTH, HEIGHT, TITLE);

        MainComponent game = new MainComponent();

        game.start();
    }
}
