package com.implemica.bormashenko.calculator.model.exceptions;

/**
 * Custom made exception which shows that dividing by zero operation was performed.
 *
 * @author Mykhailo Bormashenko
 */
public class DivideByZeroException extends Exception{

    /**
     * Message for thrown exception.
     */
    private static final String MESSAGE = "Cannot divide by zero";

    /**
     * Constructor for exception.
     */
    public DivideByZeroException() {
        super(MESSAGE);
    }
}
