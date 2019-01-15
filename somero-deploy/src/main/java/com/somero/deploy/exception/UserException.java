package com.somero.deploy.exception;

public class UserException extends Exception {

    private int code = 1000;

    public UserException(String message) {
        super(message);
    }

    public int getCode() {
        return code;
    }
}
