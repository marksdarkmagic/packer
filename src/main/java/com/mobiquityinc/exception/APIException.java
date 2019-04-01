package com.mobiquityinc.exception;

public class APIException extends RuntimeException {
    public APIException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
    public APIException(String errorMessage) {
        super(errorMessage);
    }
}
