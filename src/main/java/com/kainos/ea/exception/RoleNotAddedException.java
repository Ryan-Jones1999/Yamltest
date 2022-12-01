package com.kainos.ea.exception;

public class RoleNotAddedException extends Throwable{
    public RoleNotAddedException (String message, Exception e){
        super(message, e);
    }
}
