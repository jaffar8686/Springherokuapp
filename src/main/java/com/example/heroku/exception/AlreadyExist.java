package com.example.heroku.exception;

public class AlreadyExist  extends RuntimeException{
    public AlreadyExist(String message) {
        super(message);
    }
}
