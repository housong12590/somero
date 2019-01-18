package com.somero.deploy.exception;

public class ServiceException extends RuntimeException {

    private int code = 1000;

    public ServiceException(String message) {
        super(message);
    }

    public int getCode() {
        return code;
    }
}
