package com.implemica.bormashenko.calculator.model.exceptions;

/**
 * Custom made exception which shows that dividing zero by zero operation was performed.
 *
 * @author Mykhailo Bormashenko
 */
public class DivideZeroByZeroException extends Exception {

    /**
     * Message for thrown exception.
     */
    private static final String MESSAGE = "Result is undefined";

    /**
     * Constructor for exception.
     */
    public DivideZeroByZeroException() {
        super(MESSAGE);
    }
}