package model;

public class displayException extends Exception
{
    public displayException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public displayException(String message)
    {
        super(message);
    }
}
