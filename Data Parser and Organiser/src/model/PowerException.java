package model;

public class PowerException extends Exception
{
    public PowerException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PowerException(String message)
    {
        super(message);
    }
}
