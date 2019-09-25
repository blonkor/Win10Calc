package com.implemica.bormashenko.calculator.model.exceptions;

/**
 * Custom made exception which shows that root operation for negative number was performed.
 *
 * @author Mykhailo Bormashenko
 */
public class NegativeRootException extends Exception {

    /**
     * Message for thrown exception.
     */
    private static final String MESSAGE = "Invalid input";

    /**
     * Constructor for exception.
     */
    public NegativeRootException() {
        super(MESSAGE);
    }
}