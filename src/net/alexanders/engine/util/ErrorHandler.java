package net.alexanders.engine.util;

public class ErrorHandler
{
    //TODO: Use this class
    public static void errorAndExit(Exception exception, String message, boolean printStackTrace, int errorCode)
    {
        if(!message.equals(""))
            System.err.println(message);
        if(printStackTrace)
            exception.printStackTrace();
        System.exit(errorCode);
    }

    public static void errorAndExit(Exception exception, boolean printStackTrace, int errorCode)
    {
        errorAndExit(exception, "", printStackTrace, errorCode);
    }

    public static void errorAndExit(Exception exception, boolean printStackTrace)
    {
        errorAndExit(exception, "", printStackTrace, 1);
    }

    public static void errorAndExit(String message, boolean printStackTrace)
    {
        errorAndExit(new Exception(), message, printStackTrace, 1);
    }

    public static void error(Exception exception, String message, boolean printStackTrace)
    {
        if(!message.equals(""))
            System.err.println(message);
        if(printStackTrace)
            exception.printStackTrace();
    }

    public static void error(Exception exception, boolean printStackTrace)
    {
        error(exception, "", printStackTrace);
    }

    public static void error(String message, boolean printStackTrace)
    {
        error(new Exception(), message, printStackTrace);
    }
}
