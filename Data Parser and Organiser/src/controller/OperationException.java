package model;
import java.io.*;

public class OperationException extends Exception
{
    public OperationException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public OperationException(String message) 
    {
        super(message);
    }
}
