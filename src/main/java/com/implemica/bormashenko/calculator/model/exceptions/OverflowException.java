package com.implemica.bormashenko.calculator.model.exceptions;


public class OverflowException extends RuntimeException{

    public OverflowException(String message) {
        super(message);
    }
}
