package com.kainos.ea.exception;


public class DatabaseException extends Throwable {
    public  DatabaseException(String message, Exception e) {
        super(message, e);

    }
}
