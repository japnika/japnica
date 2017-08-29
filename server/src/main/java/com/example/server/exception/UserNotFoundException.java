package com.example.server.exception;

/**
 * Created by japnica on 8/28/2017.
 */
public class UserNotFoundException extends StudentException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
