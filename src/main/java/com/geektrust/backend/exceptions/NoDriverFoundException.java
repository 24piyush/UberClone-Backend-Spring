package com.geektrust.backend.exceptions;

public class NoDriverFoundException extends RuntimeException {

    public NoDriverFoundException()
    {
        super();
    }

    public NoDriverFoundException(String msg)
    {
        super(msg);
    }
    
}
